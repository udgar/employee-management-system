import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from 'src/app/class/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private service:EmployeeServiceService,private formBuilder:FormBuilder,private route:Router) { }
  public employee:Employee;

  ngOnInit(): void {
  }
  public registerForm=this.formBuilder.group({
    name:['',Validators.required],
    email:['',[Validators.required,Validators.pattern("^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
    phoneNumber:['',Validators.required],
    imageUrl:['',Validators.required],
    codeNumber:['',Validators.required]
})
  addEmployee(){
    this.employee=new Employee();
    this.employee.name=this.registerForm.get('name').value;
    localStorage.setItem("name",this.employee.name);
    this.employee.email=this.registerForm.get('email').value;
    localStorage.setItem("email",this.employee.email);
    this.employee.phoneNumber=this.registerForm.get('phoneNumber').value;
    localStorage.setItem("phoneNumber",this.employee.phoneNumber);
    this.employee.imageUrl=this.registerForm.get('imageUrl').value;
    localStorage.setItem("imageUrl",this.employee.imageUrl);
    this.employee.codeNumber=this.registerForm.get('codeNumber').value;
    localStorage.setItem("codeNumber",this.employee.codeNumber);
    this.service.addEmployee(this.employee).subscribe(data=>console.log(data),error=>console.log(error),
      ()=>{this.route.navigate(['/view'])}
    );
    
    this.employee=new Employee();

  }
  loadDataFromStorage(){
      this.registerForm.patchValue({
        name:localStorage.getItem('name'),
        email:localStorage.getItem("email"),
        phoneNumber:localStorage.getItem("phoneNumber"),
        imageUrl:localStorage.getItem("imageUrl"),
        codeNumber:localStorage.getItem("codeNumber")

      })

  }
  

}
