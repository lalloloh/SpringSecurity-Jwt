package br.com.laironoliveira.spring_security_jwt.api.assembler;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.laironoliveira.spring_security_jwt.api.dto.request.UserRequestDTO;
import br.com.laironoliveira.spring_security_jwt.api.dto.response.UserResponseDTO;
import br.com.laironoliveira.spring_security_jwt.domain.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserAssembler {
    
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public User toEntityFromUserRequestDTO(UserRequestDTO requestDTO) {
        User user = modelMapper.map(requestDTO, User.class);
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    public UserResponseDTO toUserResponseDTO(User user){
        return modelMapper.map(user, UserResponseDTO.class);
    }
}
