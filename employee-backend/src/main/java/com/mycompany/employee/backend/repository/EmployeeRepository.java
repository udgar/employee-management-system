
package com.mycompany.employee.backend.repository;

import com.mycompany.employee.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    public void deleteEmployeeById(Long id);
    
}
