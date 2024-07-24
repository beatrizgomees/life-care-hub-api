package com.github.beatrizgomees.api.authentication.domain.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.name());
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        return user;
    }
}
