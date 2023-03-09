package com.rs.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank(message = "Atributo obrigatorio")
    private String username;
    @NotBlank(message = "Atributo obrigatorio")
    private String password;
}
