package br.com.laironoliveira.spring_security_jwt.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.laironoliveira.spring_security_jwt.api.assembler.UserAssembler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserService service;
    private final UserAssembler userAssembler;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userAssembler.toUserAuthenticated(service.getByUsername(username));
    }
    
}
