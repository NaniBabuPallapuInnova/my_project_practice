import { Injectable, OnInit } from '@angular/core';
import { Student } from './student';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class StudentService implements OnInit {

  // data location or you can use website url.
  private _url : string = "/assets/data/student.json";


  constructor(private http : HttpClient) {
   }

  ngOnInit() {
 
  }

 //1. we are making request using 'this.http.get()' by passing 'this._url' argument to fetch data from website(or file).
 //2. Receive the observables and cast it into an Student Array.
 getEmployees() : Observable<Student[]>{
    return this.http.get<Student[]>(this._url).pipe(
      catchError(this.httpErrorHandler)
    );
  }

  httpErrorHandler(error : HttpErrorResponse){
    return throwError(error.message || "Server Error");
  }

}
