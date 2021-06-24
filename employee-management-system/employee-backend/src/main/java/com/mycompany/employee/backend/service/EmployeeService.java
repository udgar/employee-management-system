
package com.mycompany.employee.backend.service;

import com.mycompany.employee.backend.model.Employee;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(int id);
    public Employee getEmployee(int id);
    public List<Employee> getAllEmployee();
    
}
