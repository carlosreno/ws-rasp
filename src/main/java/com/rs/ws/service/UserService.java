package com.rs.ws.service;

import com.rs.ws.dto.UserDto;
import com.rs.ws.model.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Users create(UserDto userDto);
    User update(UserDto userDto);
    List<Users> findAllUsers();
    UserDto findById(Long id);


}
