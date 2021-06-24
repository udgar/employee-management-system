import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './component/add-employee/add-employee.component';
import { EditEmployeeComponent } from './component/edit-employee/edit-employee.component';
import { EmployeeDetailsComponent } from './component/employee-details/employee-details.component';
import { ViewEmployeeComponent } from './component/view-employee/view-employee.component';

const routes: Routes = [
  {path:"",redirectTo:"/view",pathMatch:"full"},
  {path:"view",component:ViewEmployeeComponent},
  {path:"add",component:AddEmployeeComponent},
  {path:"edit/:id",component:EditEmployeeComponent},
  {path:"details/:id",component:EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
