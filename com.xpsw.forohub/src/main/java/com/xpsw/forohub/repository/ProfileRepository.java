package com.xpsw.forohub.repository;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
