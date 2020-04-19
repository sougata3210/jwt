package com.javainuse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;

@Component
public class JwtUserDetailsService implements UserDetailsService {
	
	  @Autowired private UserDao userDao;
	 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//$2y$10$ndZg6y9xUfBVSSREQVEM8e6Ck4IU6o8E2Kpp2b8nsLlao0j/A3bcW
		//user@email.com for username = 'user'
		
		//DAOUser user =  userDao.findByUsername(username);
		//System.err.println(user);
		 List<DAOUser> userList = userDao.findAll();
		 userList = userList.stream()
				 .filter(elem-> elem !=null && username.equalsIgnoreCase(elem.getUsername()) )
				 .collect(Collectors.toList());

		if (userList != null && !userList.isEmpty()) {
			return new User(userList.get(0).getUsername(), userList.get(0).getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found");
		}
		 
		/*
		 * if("javainuse".equals(username)) { return new User("javainuse",
		 * "$2a$10$MoW82CLVs4ddYrszMnWIjeAxQmUraLGwD8xkCTJpxfyf18w17uOZa", new
		 * ArrayList<>()); }else { throw new
		 * UsernameNotFoundException("User not found"); }
		 */
		
	}

}
