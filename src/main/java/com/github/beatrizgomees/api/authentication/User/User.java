package com.github.beatrizgomees.api.authentication.User;
import com.github.beatrizgomees.api.authentication.dto.LoginRequest;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Getter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String username;


    private String email;

    private String password;

    public User() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String email, String username, String passwordHash) {
        this();
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = passwordHash;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder){
       return passwordEncoder.matches(loginRequest.password(),this.password);
    }
}
