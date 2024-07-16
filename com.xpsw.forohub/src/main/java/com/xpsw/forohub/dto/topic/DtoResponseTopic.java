package com.xpsw.forohub.dto.topic;

import com.example.forohub.dto.user.*;
import com.xpsw.forohub.dto.user.DtoUser;

import java.time.LocalDateTime;

public record DtoResponseTopic (
        LocalDateTime creationDate,
        String message,
        String solution,
        DtoUser author
)
{
}
