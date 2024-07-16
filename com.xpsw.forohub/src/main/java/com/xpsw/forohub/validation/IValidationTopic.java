package com.xpsw.forohub.validation;

import com.example.forohub.dto.topic.*;
import com.xpsw.forohub.dto.topic.DtoCreateTopicToDatabase;

public interface IValidationTopic {

    public void checkValidation(DtoCreateTopicToDatabase dataTopic);
}
