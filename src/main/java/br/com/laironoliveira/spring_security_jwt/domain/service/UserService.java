package br.com.laironoliveira.spring_security_jwt.domain.service;

import org.springframework.stereotype.Service;

import br.com.laironoliveira.spring_security_jwt.domain.dao.UserDAO;
import br.com.laironoliveira.spring_security_jwt.domain.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserDAO dao;

    public User getByUuid(String uuid) {
        var user = dao.findFirstByUuid(uuid);
        if (user.isPresent())
            return user.get();
        else
            throw new EntityNotFoundException("User not found");
    }

    public User getByUsername(String username) {
        var user = dao.findFirstByUsername(username);
        if (user.isPresent())
            return user.get();
        else
            throw new EntityNotFoundException("User not found");
    }
}
