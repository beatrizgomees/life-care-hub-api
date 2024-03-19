package com.github.beatrizgomees.api.authentication.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
//é utilizada para indicar que uma classe é responsável
// por acessar e manipular dados no banco de dados ou
// em outra fonte de dados externa
public interface UserRepository extends CrudRepository<User, UUID> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
