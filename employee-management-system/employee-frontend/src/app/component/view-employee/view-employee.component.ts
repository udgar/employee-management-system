import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Employee } from 'src/app/class/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  
  public employees:Employee[];
  public employee:Employee
  public identity:number

  constructor(private service:EmployeeServiceService,private route:Router,private active:ActivatedRoute) { }

  ngOnInit(): void {
    this.active.paramMap.subscribe((params:ParamMap)=>{
      this.identity=parseInt(params.get('id'))
  });
    this.service.getEmployee().subscribe(data=>{this.employees=data},
        (error:HttpErrorResponse)=>{alert(error.message)}
      )
      console.log(this.employees);

  }
  delete(emp:Employee){
    console.log(emp.id);
    this.service.deleteEmployee(emp.id).subscribe(data=>console.log(data),error=>console.log(error))
    this.route.routeReuseStrategy.shouldReuseRoute=()=>false;
    this.route.onSameUrlNavigation='reload';
    this.route.navigate(['/',{relativeTo:this.route}])

  }
  update(emp:Employee){
    const id=emp.id;
    console.log(id);
    this.route.navigate(['/edit',id]);
  }
  getDetails(emp:Employee){
    console.log(emp);
    this.route.navigate(['/details',emp.id])
  }
  isSelected(emp:Employee):boolean{
    return emp.id==this.identity;
  }
  public highlighted="selected"

}
