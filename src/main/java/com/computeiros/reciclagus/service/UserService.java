package com.computeiros.reciclagus.service;

import com.computeiros.reciclagus.dto.UserRegistrationDto;
import com.computeiros.reciclagus.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}