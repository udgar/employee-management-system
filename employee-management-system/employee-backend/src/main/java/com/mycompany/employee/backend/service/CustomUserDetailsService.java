/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employee.backend.service;

import com.mycompany.employee.backend.model.CustomUserDetails;
import com.mycompany.employee.backend.model.UserEntity;
import com.mycompany.employee.backend.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user=userRepository.findByUserName(userName);
       if(user==null){
           throw new UsernameNotFoundException("The given user is not valid");
       }
       else{
           return new CustomUserDetails(user);
       }
    }

    
}
