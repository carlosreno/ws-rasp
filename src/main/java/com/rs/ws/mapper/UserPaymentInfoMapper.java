package com.rs.ws.mapper;

import com.rs.ws.dto.UserPaymentInfoDto;
import com.rs.ws.model.UserPaymenteInfor;
import com.rs.ws.model.Users;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserPaymentInfoMapper {

    public static UserPaymenteInfor fromDtoToEntity(UserPaymentInfoDto dto, Users user){
        return UserPaymenteInfor.builder()
                .id(dto.getId())
                .cardNumber(dto.getCardNumber())
                .cardExpirationMonth(dto.getCardExpirationMonth())
                .dtPayment(dto.getDtPayment())
                .price(dto.getPrice())
                .cardSecurityCode(dto.getCardSecurityCode())
                .cardExpirationYear(dto.getCardExpirationYear())
                .user(user)
                .build();
    }

}
