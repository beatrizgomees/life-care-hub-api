package com.github.beatrizgomees.api.authentication.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.beatrizgomees.api.authentication.User.UserRequest;
import com.github.beatrizgomees.api.authentication.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserRequestProducer {

    @Value("${spring.pulsar.producer.topic-name}")
    private String topicUserRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public String sendMessage(LoginRequest loginRequest) throws JsonProcessingException {
        String messageContent = objectMapper.writeValueAsString(loginRequest);
        kafkaTemplate.send(topicUserRequest, messageContent);
        System.out.println(topicUserRequest);
        return "Requisição de User";
    }
}
