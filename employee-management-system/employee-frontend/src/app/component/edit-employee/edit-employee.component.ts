import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Employee } from 'src/app/class/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private active:ActivatedRoute,private route:Router,public service:EmployeeServiceService) { }
  public identity
  public employee;
  public registerForm;

  ngOnInit(): void {
    this.active.paramMap.subscribe((params:ParamMap)=>{
      this.identity=parseInt(params.get('id'));     
  });
    this.registerForm=this.formBuilder.group({
      name:['',Validators.required],
      email:['',[Validators.required,Validators.pattern("^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      phoneNumber:['',Validators.required],
      imageUrl:['',Validators.required],
      codeNumber:['',Validators.required]
    })
  
  }
  editEmployee(){
    this.employee=new Employee();
    this.employee.name=this.registerForm.get('name').value;
    this.employee.email=this.registerForm.get('email').value;
    this.employee.phoneNumber=this.registerForm.get('phoneNumber').value;
    this.employee.imageUrl=this.registerForm.get('imageUrl').value;
    this.employee.codeNumber=this.registerForm.get('codeNumber').value;
    this.employee.id=this.identity;
    this.service.updateEmployee(this.employee).subscribe(data=>console.log(data),error=>console.log(error),
      ()=>{this.route.navigate(['/view'])}
    );
    this.employee=new Employee();
  }
  loadStorageValue(){
    this.registerForm.patchValue({
      name:localStorage.getItem('name'),
      email:localStorage.getItem("email"),
      phoneNumber:localStorage.getItem("phoneNumber"),
      imageUrl:localStorage.getItem("imageUrl"),
      codeNumber:localStorage.getItem("codeNumber")

    })
  }
}
