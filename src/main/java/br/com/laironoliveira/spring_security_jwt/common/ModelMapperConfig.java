package br.com.laironoliveira.spring_security_jwt.common;

import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.laironoliveira.spring_security_jwt.api.dto.request.UserRequestDTO;
import br.com.laironoliveira.spring_security_jwt.api.dto.response.UserResponseDTO;
import br.com.laironoliveira.spring_security_jwt.domain.model.User;

@Configuration
public class ModelMapperConfig {
  
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(UserRequestDTO.class, User.class);

        modelMapper.createTypeMap(User.class, UserResponseDTO.class);

        return modelMapper;
    }
}
