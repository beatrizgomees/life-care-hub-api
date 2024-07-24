package com.github.beatrizgomees.api.authentication.domain.User;

import com.github.beatrizgomees.api.authentication.service.email.EmailFormatException;
import com.github.beatrizgomees.api.authentication.service.email.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
// is used in service classes to indicate that the class
// contains the application's business logic
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;
    // is used to inject an instance of a
    // class managed by Spring into another class.
    // This annotation can be used to inject objects into
    // constructors, fields and methods. When Spring meets
    // a field or method with the @Autowired annotation,
    // it searches for an object of the corresponding type
    // in the application context and automatically injects it.



    public void save(UserRequest  userRequest) throws EmailFormatException {
        if(userRepository.existsByUsername(userRequest.username())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This Username is already being used" );
        }
        if(userRepository.existsByEmail(userRequest.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This email is already being used" );

        }
        if(!EmailValidator.emailValidate(userRequest.email())){
            throw new EmailFormatException("This email is in incorrect format");
        }

        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
    }

    public User findById(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User with id '" + id + "' not found"));
    }


}
