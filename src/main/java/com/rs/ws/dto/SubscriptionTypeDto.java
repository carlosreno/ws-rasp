package com.rs.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionTypeDto {

    private Long id;
    @NotBlank(message = "Campo não pode ser nulo ou vazio")
    @Size(min = 5, max = 12)
    private String name;
    @Max(value = 12, message = "campo não pode ser maior que 12")
    private Long acessMonth;
    @NotNull(message = "não pode ser nulo")
    private BigDecimal price;
    @NotBlank(message = "não pode ser nulo ou vazio")
    @Size(min = 5, max = 12)
    private String pruductKey;


}
