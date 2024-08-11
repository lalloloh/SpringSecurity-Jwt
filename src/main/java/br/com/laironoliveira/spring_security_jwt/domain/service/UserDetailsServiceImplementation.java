package br.com.laironoliveira.spring_security_jwt.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return service.getByUsername(username);
    }
    
}
