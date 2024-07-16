package com.xpsw.forohub.validation;

import com.example.forohub.dto.topic.*;
import com.example.forohub.validation.*;
import com.example.forohub.repository.*;
import com.example.forohub.model.*;
import com.xpsw.forohub.dto.topic.DtoCreateTopicToDatabase;
import com.xpsw.forohub.model.Topic;
import com.xpsw.forohub.repository.TopicRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateNoEqualTitleOrMessage implements IValidationTopic
{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public void checkValidation(DtoCreateTopicToDatabase dataTopic)
    {
        Topic topicData = topicRepository.findTopicByTitleOrMessage(dataTopic.title(), dataTopic.message());

        if(topicData != null)
        {
            throw new ValidationException("El tema existe con título o descripción del mensaje");
        }
    }
}
