package com.rs.ws.mapper.wsraspay;

import com.rs.ws.dto.wsraspay.CustomerDto;
import com.rs.ws.model.Users;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

    public static CustomerDto build(Users user){
        var fullName = user.getName().split(" ");
        var firtName = fullName[0];
        var lastName = fullName.length-1 >= 1 ? fullName[fullName.length-1]:"";
        System.out.println(firtName+"  "+lastName);
        return CustomerDto.builder()
                .cpf(user.getCpf())
                .email(user.getEmail())
                .firstName(firtName)
                .lastName(lastName)
                .build();
    }
}
