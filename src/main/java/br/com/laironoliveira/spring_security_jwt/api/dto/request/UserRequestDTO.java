package br.com.laironoliveira.spring_security_jwt.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
