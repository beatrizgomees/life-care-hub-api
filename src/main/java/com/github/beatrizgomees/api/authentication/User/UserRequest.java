package com.github.beatrizgomees.api.authentication.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


public record UserRequest(

     @NotBlank
     String name,

     @NotBlank
     @Size(max = 30)
     String username,


     @NotBlank
     @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")
     String email,

     @NotBlank
     @Size(min = 6, max = 8)
     String password
) {
     @Override
     public String name() {
          return name;
     }

     @Override
     public String username() {
          return username;
     }

     @Override
     public String email() {
          return email;
     }

     @Override
     public String password() {
          return password;
     }
}
