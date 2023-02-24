package com.rs.ws.service.impl;

import com.rs.ws.dto.UserDto;
import com.rs.ws.exception.BadRequest;
import com.rs.ws.exception.NotFoundException;
import com.rs.ws.mapper.UserMapper;
import com.rs.ws.model.Users;
import com.rs.ws.repository.UserRepository;
import com.rs.ws.repository.UserTypeRepository;
import com.rs.ws.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    public UserServiceImpl(UserTypeRepository userTypeRepository,UserRepository userRepository) {
        this.userRepository=userRepository;
        this.userTypeRepository=userTypeRepository;
    }

    @Override
    public Users create(UserDto userDto) {
        if (Objects.nonNull(userDto.getId())){
            throw new BadRequest("id deve ser nulo");
        }
        var userTypeOpt = userTypeRepository.findById(userDto.getUserTypeId());
        if (userTypeOpt.isEmpty()){
            throw new NotFoundException("userType não encontrado");
        }
        Users user = UserMapper.fromDtoToEntity(userDto,userTypeOpt.get(),null);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDto userDto) {
        return null;
    }

    @Override
    public List<Users> findAllUsers() {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }
}
