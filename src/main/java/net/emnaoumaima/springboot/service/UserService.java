package net.emnaoumaima.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.emnaoumaima.springboot.model.User;
import net.emnaoumaima.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	
}
