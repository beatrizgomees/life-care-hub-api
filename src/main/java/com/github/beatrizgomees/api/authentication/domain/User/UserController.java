package com.github.beatrizgomees.api.authentication.domain.User;

import com.github.beatrizgomees.api.authentication.service.email.EmailFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody UserRequest user) throws EmailFormatException {
        userService.save(user);
        return ResponseEntity.ok().build();
    }


}
