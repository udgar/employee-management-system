import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { AddEmployeeComponent } from './component/add-employee/add-employee.component';
import { ViewEmployeeComponent } from './component/view-employee/view-employee.component';
import { ReactiveFormsModule } from '@angular/forms';
import { EditEmployeeComponent } from './component/edit-employee/edit-employee.component';
import { EmployeeDetailsComponent } from './component/employee-details/employee-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AddEmployeeComponent,
    ViewEmployeeComponent,
    EditEmployeeComponent,
    EmployeeDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
