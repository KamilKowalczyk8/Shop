package com.example.demo.configuration;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findUserByLogin(username);
        return user.map(CustomerUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found with name"+username));
    }
}
