package com.rs.ws.mapper.wsraspay;

import com.rs.ws.dto.UserPaymentInfoDto;
import com.rs.ws.dto.wsraspay.CreditCardDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreditCardMapper {
    public static CreditCardDto build(UserPaymentInfoDto dto, String documentNumber){
        return CreditCardDto.builder()
                .documentNumber(documentNumber)
                .number(dto.getCardNumber())
                .month(dto.getCardExpirationMonth())
                .year(dto.getCardExpirationYear())
                .cvv(Long.parseLong(dto.getCardSecurityCode()))
                .installments(dto.getInstallments())
                .build();
    }
}
