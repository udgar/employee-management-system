
package com.mycompany.employee.backend.repository;

import com.mycompany.employee.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    //Fing the User using the available username
    public UserEntity findByUserName(String userName);
}
