package br.com.laironoliveira.spring_security_jwt.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("username")
    private String username;
}
