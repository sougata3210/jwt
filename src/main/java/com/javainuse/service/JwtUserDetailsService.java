package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//$2y$10$ndZg6y9xUfBVSSREQVEM8e6Ck4IU6o8E2Kpp2b8nsLlao0j/A3bcW
		if("javainuse".equals(username)) {
			return new User("javainuse",
					"$2a$10$MoW82CLVs4ddYrszMnWIjeAxQmUraLGwD8xkCTJpxfyf18w17uOZa",
					new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
		
		
	}

}
