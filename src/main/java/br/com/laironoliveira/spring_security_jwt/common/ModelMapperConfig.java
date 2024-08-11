package br.com.laironoliveira.spring_security_jwt.common;

import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.laironoliveira.spring_security_jwt.domain.model.User;
import br.com.laironoliveira.spring_security_jwt.domain.model.UserAuthenticated;

@Configuration
public class ModelMapperConfig {
  
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(User.class, UserAuthenticated.class);

        return modelMapper;
    }
}
