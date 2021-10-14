package com.mefunny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mefunny.repository.UserRepository;

@Service
public class MeFunnyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final com.mefunny.model.User user = userRepository.findByUserName(username);
        
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		
        UserDetails userDetails = org.springframework.security.core.userdetails.User
        		.withUsername( user.getUserName() )
        		.password( user.getPassword() )
        		.authorities("USER").build();
        return userDetails;
    }
}