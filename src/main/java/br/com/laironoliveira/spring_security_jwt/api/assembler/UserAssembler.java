package br.com.laironoliveira.spring_security_jwt.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.laironoliveira.spring_security_jwt.domain.model.User;
import br.com.laironoliveira.spring_security_jwt.domain.model.UserAuthenticated;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserAssembler {
    
    private ModelMapper modelMapper;

    public UserAuthenticated toUserAuthenticated(User user){
        return modelMapper.map(user, UserAuthenticated.class);
    }
}
