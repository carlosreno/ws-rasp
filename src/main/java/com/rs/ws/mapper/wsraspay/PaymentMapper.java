package com.rs.ws.mapper.wsraspay;

import com.rs.ws.dto.wsraspay.CreditCardDto;
import com.rs.ws.dto.wsraspay.PayentDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {
    public static PayentDto build(String customerId, String orderId, CreditCardDto dto){
        return PayentDto.builder()
                .customerId(customerId)
                .orderId(orderId)
                .creditCard(dto)
                .build();
    }
}
