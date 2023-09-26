import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  public url : string = 'http://localhost:8008/enroll';
  constructor(private httpClient : HttpClient) {

   }

   enroll(student : Student){
    return this.httpClient.post<any>(this.url, student);
   }
}
