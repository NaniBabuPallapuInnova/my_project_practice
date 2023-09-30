import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService{

  public url : string = 'http://localhost:8008/enroll';

  constructor( private httpClient : HttpClient) { 

  }
  
  register(userData : any){
    return this.httpClient.post<any>(this.url, userData)
  }
  
}
