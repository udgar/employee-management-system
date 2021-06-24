
package com.mycompany.employee.backend.controller;

import com.mycompany.employee.backend.model.Employee;
import com.mycompany.employee.backend.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees=employeeService.getAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    
    @GetMapping("/find/{employeeId}")
    public ResponseEntity<Employee> getOneEmployee(@PathVariable("employeeId")int studentId){
        Employee employee= employeeService.getEmployee(studentId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employeeAdd = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeAdd,HttpStatus.OK);
    }
    
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employeeUpdate = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employeeUpdate,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{employeeId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity deleteEmployee(@PathVariable("employeeId")int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @GetMapping("/check-access")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity checkAccess(){
        return ResponseEntity.status(200).body("");
    }
}
