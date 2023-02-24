package com.rs.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPaymentInfoDto {

    private Long id;
    @Min(value = 1)
    @Max(value = 12)
    private String cardNumber;
    private Long cardExpirationMonth;
    private Long cardExpirationYear;
    @Max(value = 3)
    @Min(value = 3)
    private String cardSecurityCode;
    private BigDecimal price;
    private LocalDate dtPayment = LocalDate.now();

    private Long installments;
    @NotNull(message = "deve ser informado")
    private Long userId;
}
