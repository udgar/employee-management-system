
package com.mycompany.employee.backend.service;

import com.mycompany.employee.backend.model.UserEntity;
import com.mycompany.employee.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
    
}
