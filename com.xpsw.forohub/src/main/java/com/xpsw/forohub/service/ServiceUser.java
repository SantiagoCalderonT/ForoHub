package com.xpsw.forohub.service;

import com.example.forohub.dto.user.*;
import com.example.forohub.repository.*;
import com.example.forohub.model.*;
import com.example.forohub.security.*;
import com.xpsw.forohub.dto.user.*;
import com.xpsw.forohub.model.Profile;
import com.xpsw.forohub.model.User;
import com.xpsw.forohub.repository.ProfileRepository;
import com.xpsw.forohub.repository.UserRepository;
import com.xpsw.forohub.security.TokenService;
import jakarta.validation.ValidationException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public DtoResponseTokenData authenticateUser(DtoLoginDataUser dtoLoginDataUser)
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dtoLoginDataUser.username(),
                dtoLoginDataUser.password());

        var userAuthenticate = authenticationManager.authenticate(authenticationToken);
        var JWTtoken = tokenService.generateToken((User) userAuthenticate.getPrincipal());

        DtoResponseTokenData dtoResponseTokenData = new DtoResponseTokenData(JWTtoken,
                "Bearer");

        return dtoResponseTokenData;
    }

    public DtoUserMoreDetails findUserById(Long id)
    {
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isPresent())
        {
            DtoUserMoreDetails dtoUserMoreDetails = new DtoUserMoreDetails(userOptional.get().getCode(),
                    userOptional.get().getUsername(),
                    userOptional.get().getEmail(),
                    userOptional.get().getProfile().getName());

            return dtoUserMoreDetails;
        }
        else
        {
            throw new ValidationException("El tipo de perfil no existe, por favor verifique los perfiles");
        }
    }

    public List<DtoUserMoreDetails> findAllUsers()
    {
        List<User> userRepositoriesList =userRepository.findAll();

        List<DtoUserMoreDetails> dtoUserMoreDetailsList = userRepositoriesList.stream()
                .map(u -> new DtoUserMoreDetails(u.getCode(),
                        u.getUsername(),
                        u.getEmail(),
                        u.getProfile().getName()))
                .toList();

        return dtoUserMoreDetailsList;
    }

    public DtoUserMoreDetails createNewUser(DtoCreateUser dtoCreateUser)
    {
        Optional<Profile> profile = profileRepository.findById(Long.valueOf(dtoCreateUser.typeOfProfile()));

        if(profile.isPresent())
        {
            DtoCreateUserToDatabase dtoCreateUserToDatabase = new DtoCreateUserToDatabase(dtoCreateUser.username(),
                    dtoCreateUser.email(),
                    encryptPassword(dtoCreateUser.password()),
                    profile.get());

            User userCreated = new User(dtoCreateUserToDatabase);

            userRepository.save(userCreated);

            DtoUserMoreDetails dtoUserMoreDetails = new DtoUserMoreDetails(userCreated.getCode(),
                    userCreated.getUsername(),
                    userCreated.getEmail(),
                    userCreated.getProfile().getName());

            return dtoUserMoreDetails;
        }
        else
        {
            throw new ValidationException("El tipo de perfil no existe, por favor verifique los perfiles");
        }
    }

    public DtoUserMoreDetails updateUser(Long id, DtoUpdateUser dtoUpdateUser)
    {
        Optional<Profile> profile = profileRepository.findById(Long.valueOf(dtoUpdateUser.typeOfProfile()));
        Optional<User> userSearched = userRepository.findById(id);

        if(profile.isPresent())
        {
            if(userSearched.isPresent())
            {
                User getUser = userSearched.get();

                getUser.setUsername(dtoUpdateUser.username());
                getUser.setEmail(dtoUpdateUser.email());
                getUser.setEmail(dtoUpdateUser.email());
                getUser.setProfile(profile.get());

                DtoUserMoreDetails dtoUserMoreDetails = new DtoUserMoreDetails(getUser.getCode(),
                        getUser.getUsername(),
                        getUser.getEmail(),
                        getUser.getProfile().getName());

                return dtoUserMoreDetails;
            }
            else
            {
                throw new ValidationException("El usuario no existe");
            }
        }
        else
        {
            throw new ValidationException("El tipo de perfil no existe, por favor verifique los perfiles");
        }
    }

    private String encryptPassword(String password)
    {
        return new BCryptPasswordEncoder().encode(password);
    }
}
