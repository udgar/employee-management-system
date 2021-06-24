package com.mycompany.employee.backend.model;

import com.mycompany.employee.backend.enumerations.Gender;
import com.mycompany.employee.backend.enumerations.Position;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Gender gender;
    
    @Column(nullable=false)
    private String email;
    
    @Column(nullable=false)
    private String phoneNumber;
    
    @Column(nullable=true)
    private String imageUrl;
    
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Position position;


}
