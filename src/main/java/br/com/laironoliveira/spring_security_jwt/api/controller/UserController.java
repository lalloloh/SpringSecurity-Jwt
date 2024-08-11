package br.com.laironoliveira.spring_security_jwt.api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laironoliveira.spring_security_jwt.api.assembler.UserAssembler;
import br.com.laironoliveira.spring_security_jwt.api.dto.request.UserRequestDTO;
import br.com.laironoliveira.spring_security_jwt.api.dto.response.UserResponseDTO;
import br.com.laironoliveira.spring_security_jwt.domain.exception.UserAlreadyExists;
import br.com.laironoliveira.spring_security_jwt.domain.model.User;
import br.com.laironoliveira.spring_security_jwt.domain.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private UserService userService;
    private UserAssembler userAssembler;
    
    @PostMapping()
    public ResponseEntity<UserResponseDTO> postUser(HttpServletRequest httpServletRequest, @RequestBody UserRequestDTO requestDTO) throws Exception {
        if (userService.userExistsByUsername(requestDTO.getUsername()))
            throw new UserAlreadyExists("Usuário já cadastrado: %s".formatted(requestDTO.getUsername()));
        
        User user = userAssembler.toEntityFromUserRequestDTO(requestDTO);
        userService.save(user);
        var creationUri = new URI("%s/%s".formatted(httpServletRequest.getRequestURL(), user.getUuid()));

        return ResponseEntity.created(creationUri).body(userAssembler.toUserResponseDTO(user));
    }
    
}
