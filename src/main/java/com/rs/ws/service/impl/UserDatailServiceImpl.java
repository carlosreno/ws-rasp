package com.rs.ws.service.impl;
import com.rs.ws.exception.NotFoundException;
import com.rs.ws.repository.UserDatailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailServiceImpl implements UserDetailsService {
    private final UserDatailsRepository userDatailsRepository;

    public UserDatailServiceImpl(UserDatailsRepository userDatailsRepository) {
        this.userDatailsRepository = userDatailsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = userDatailsRepository.findByUserName(username);
        return optUser.orElseThrow(() -> new NotFoundException("usuário não encontrado"));

    }
}
