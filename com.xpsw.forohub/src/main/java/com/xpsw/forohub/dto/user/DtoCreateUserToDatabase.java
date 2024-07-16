package com.xpsw.forohub.dto.user;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateUserToDatabase (String username,
                                       String email,
                                       String passwordEncrypted,
                                       Profile typeOfProfile){
}
