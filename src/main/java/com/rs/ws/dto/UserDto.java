package com.rs.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "não pode ser nulo")
    @Size(min = 6, message = "valor minimo é 6 caracteres")
    private String name;

    @Email(message = "inválido")
    private String email;

    @Size(min = 11,message = "valor minimo 11 caracteres")
    private String phone;
    @CPF(message = "inválido")
    private  String cpf;
    private LocalDate dtSubcription = LocalDate.now();
    private LocalDate dtExpiration = LocalDate.now();

    @NotNull
    private Long userTypeId;
    private Long subcriptionTypeId;
}
