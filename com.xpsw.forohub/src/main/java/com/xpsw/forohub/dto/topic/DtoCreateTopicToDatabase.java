package com.xpsw.forohub.dto.topic;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Course;
import com.xpsw.forohub.model.Status;
import com.xpsw.forohub.model.User;

public record DtoCreateTopicToDatabase (
        String title,
        String message,
        User user,
        Course course,
        Status status
)
{
}
