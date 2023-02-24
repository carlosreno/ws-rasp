package com.rs.ws.mapper;

import com.rs.ws.dto.UserDto;
import com.rs.ws.model.SubscriptionType;
import com.rs.ws.model.UserType;
import com.rs.ws.model.Users;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static Users fromDtoToEntity(UserDto userDto, UserType userType, SubscriptionType subscriptionType){
        return Users.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .cpf(userDto.getCpf())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .userType(userType)
                .dtExpiration(userDto.getDtExpiration())
                .dtSubcription(userDto.getDtSubcription())
                .subscriptionType(subscriptionType)
                .build();
    }
}
