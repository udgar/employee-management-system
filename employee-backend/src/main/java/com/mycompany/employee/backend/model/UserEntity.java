
package com.mycompany.employee.backend.model;

import com.mycompany.employee.backend.enumerations.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String userName;
    
    private String password;
    
    private String emailId;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    private boolean enabled=true;
    
   

}
