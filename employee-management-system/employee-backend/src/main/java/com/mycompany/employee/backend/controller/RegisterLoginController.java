
package com.mycompany.employee.backend.controller;

import com.mycompany.employee.backend.model.ResponseClass;
import com.mycompany.employee.backend.model.UserEntity;
import com.mycompany.employee.backend.service.CustomUserDetailsService;
import com.mycompany.employee.backend.service.UserService;
import com.mycompany.employee.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RegisterLoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    JwtUtil jwtUtil;
    
    @Autowired
    UserService userService;
    
    
    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody UserEntity userEntity) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUserName(), userEntity.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect user name or password");
        }
        UserDetails userDeatails=customUserDetailsService.loadUserByUsername(userEntity.getUserName());
        String token=jwtUtil.generateToken(userDeatails);
        System.out.println("Token provided is"+token);
        return ResponseEntity.ok(new ResponseClass(token));
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        try{
            UserEntity user=userService.registerUser(userEntity);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(NullPointerException nullpointerException){
            return ResponseEntity.status(500).body("Some facts were null");
        }
    }

    
}
