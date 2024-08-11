package br.com.laironoliveira.spring_security_jwt.domain.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.laironoliveira.spring_security_jwt.domain.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long>{
    
    Optional<User> findFirstByUuid(String uuid);
    Optional<User> findFirstByUsername(String username);
    boolean existsByUsername(String username);
}
