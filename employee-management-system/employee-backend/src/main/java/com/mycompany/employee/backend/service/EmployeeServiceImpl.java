
package com.mycompany.employee.backend.service;

import com.mycompany.employee.backend.model.Employee;
import com.mycompany.employee.backend.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    EmployeeRepository employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
        
    }

    @Override
    public Employee updateEmployee(Employee employee) {
     return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
    
}
