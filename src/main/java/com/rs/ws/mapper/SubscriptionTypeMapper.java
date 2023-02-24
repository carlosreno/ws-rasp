package com.rs.ws.mapper;

import com.rs.ws.dto.SubscriptionTypeDto;
import com.rs.ws.model.SubscriptionType;
public class SubscriptionTypeMapper {

    private SubscriptionTypeMapper() {
    }

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto subscriptionTypeDto) {
        return SubscriptionType.builder()
                .id(subscriptionTypeDto.getId())
                .name(subscriptionTypeDto.getName())
                .acessMonth(subscriptionTypeDto.getAcessMonth())
                .price(subscriptionTypeDto.getPrice())
                .pruductKey(subscriptionTypeDto.getPruductKey())
                .build();
    }

}
