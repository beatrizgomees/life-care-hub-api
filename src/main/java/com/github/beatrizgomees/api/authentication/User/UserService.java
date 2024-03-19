package com.github.beatrizgomees.api.authentication.User;

import com.github.beatrizgomees.api.authentication.email.EmailFormatException;
import com.github.beatrizgomees.api.authentication.email.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// é utilizada em classes de serviço para indicar que a classe
// contém a lógica de negócio da aplicação
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;
    //é usada para injetar uma instância de uma
    // classe gerenciada pelo Spring em outra classe.
    // Essa anotação pode ser usada para injetar objetos em
    // construtores, campos e métodos. Quando o Spring encontra
    // um campo ou método com a anotação @Autowired,
    // ele procura por um objeto do tipo correspondente
    // no contexto do aplicativo e o injeta automaticamente.



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


}
