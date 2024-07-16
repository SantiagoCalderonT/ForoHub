package com.xpsw.forohub.repository;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>
{
}
