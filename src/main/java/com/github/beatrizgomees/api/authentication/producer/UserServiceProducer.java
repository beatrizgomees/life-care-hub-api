package com.github.beatrizgomees.api.authentication.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.beatrizgomees.api.authentication.User.UserRequest;
import com.github.beatrizgomees.api.authentication.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceProducer {

    @Autowired
    private UserRequestProducer userRequestProducer;

    public String integrationAutheticationUser(LoginRequest loginRequest){
        try {
          return  userRequestProducer.sendMessage(loginRequest);
        } catch (JsonProcessingException e) {
          return "Erro na autenticação do usuário" + e.getMessage();
        }
    }
}
