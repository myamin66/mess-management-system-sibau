package com.iba.messmanagementsystem.security;

import com.iba.messmanagementsystem.models.UserModel;
import com.iba.messmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrinciples(user);
    }
}
