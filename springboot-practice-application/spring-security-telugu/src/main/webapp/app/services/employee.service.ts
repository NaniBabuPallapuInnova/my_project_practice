import { Injectable } from '@angular/core';
import { Observable, catchError, map, throwError } from 'rxjs';
import { Employee } from '../interfaces/employee';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:9999/api';

  constructor(private httpClient: HttpClient, private router:Router) {

  }


  redirectTo(uri: string) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([uri])});
      location.reload();
  }

  getEmployeesList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.baseUrl + "/employees").pipe(
      catchError(error => {
        console.error('can not fetch employees list');
        return throwError('Unable to fetch employees list : ', error);
      })
    )
  }



  createEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(this.baseUrl + '/save/employee', employee).pipe(
      catchError(error => {
        console.log('failed to create an new employee', error);
        return throwError('unable to create employee', error)
      })
    );
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(this.baseUrl + '/update/employee/${id}', employee).pipe(
      catchError(error => {
        console.log('failed to update existing employee', error);
        return throwError('unable to update employee', error)
      })
    );
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseUrl}/get/employee/${id}`).pipe(
      catchError( error => {
        console.log('failed to fetch an existing employee', id);
        return throwError('unable to fetch employee'+error);
      })
    )
  }
  
  deleteEmployeeById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/delete/employee/${id}`).pipe(
      catchError(error => {
        console.log('failed to delete an existing employee', error);
        return throwError('unable to delete employee', error)
      })
    );
  }
}
