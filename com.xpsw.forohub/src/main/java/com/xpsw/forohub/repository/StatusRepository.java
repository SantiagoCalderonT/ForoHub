package com.xpsw.forohub.repository;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
