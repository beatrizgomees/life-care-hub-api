package com.github.beatrizgomees.api.authentication.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
// is used to indicate that a class is responsible
// for accessing and manipulating data in the database or
// in another external data source
public interface UserRepository extends CrudRepository<User, UUID> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

}
