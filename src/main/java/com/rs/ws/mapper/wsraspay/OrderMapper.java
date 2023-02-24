package com.rs.ws.mapper.wsraspay;

import com.rs.ws.dto.PaymentProcessDto;
import com.rs.ws.dto.wsraspay.OrderDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderMapper {
    public static OrderDto build(String customerId, PaymentProcessDto dto){
        return OrderDto.builder()
                .discount(dto.getDiscount())
                .customerId(customerId)
                .productAcronym(dto.getProductKey())
                .build();
    }
}
