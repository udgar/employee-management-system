import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable ,throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import { Employee } from '../class/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  constructor(private http:HttpClient) { }
  private apiUrl="localhost:8081/employee";

  public getEmployee():Observable<Employee[]>{
    return this.http.get<Employee[]>(`http://localhost:8081/employee/all`);
  }
  public getSingleEmployee(id:number):Observable<Employee>{
    return this.http.get<Employee>("http://localhost:8081/employee/find/"+id);
  }
  public addEmployee(employee:Employee):Observable<Employee>{
    return this.http.post<Employee>(`http://localhost:8081/employee/add`,employee);
  }
  public updateEmployee(employee:Employee):Observable<Employee>{
    console.log(employee)
    return this.http.post<Employee>("http://localhost:8081/employee/update",employee);
  }
  public deleteEmployee(id:number):Observable<any>{
    return this.http.delete("http://localhost:8081/employee/delete/"+id)
  }

  public handleError(error:HttpErrorResponse){
    
  }
}
