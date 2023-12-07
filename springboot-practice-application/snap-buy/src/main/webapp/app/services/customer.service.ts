import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_BASE_URL } from '../constants/app.constants';
import { Customer } from '../interfaces/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient : HttpClient) { 

  }



  getCustomers():Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(API_BASE_URL+'/'+'display_customers');
  }
}
