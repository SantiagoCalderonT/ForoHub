package com.xpsw.forohub.dto.topic;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Course;
import com.xpsw.forohub.model.Status;
import com.xpsw.forohub.model.User;

import java.time.LocalDateTime;

public record DtoTopicData (
        String title,
        String message,
        LocalDateTime creationdate,
        Status status,
        User author,
        Course course
)
{
}
