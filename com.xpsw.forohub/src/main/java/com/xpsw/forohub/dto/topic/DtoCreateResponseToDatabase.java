package com.xpsw.forohub.dto.topic;

import com.example.forohub.model.*;
import com.xpsw.forohub.model.Topic;
import com.xpsw.forohub.model.User;

public record DtoCreateResponseToDatabase(
        String message,
        Topic topic,
        User author,
        String solution
) {
}
