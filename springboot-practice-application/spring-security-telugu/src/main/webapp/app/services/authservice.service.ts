import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  private apiUrl = 'http://localhost:9999/api/login';

  constructor(private httpClient: HttpClient, private router: Router) {

  }

  login(username: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password);

    return this.httpClient.get<any>(this.apiUrl, { params, withCredentials: true })
      .pipe(
        catchError(error => {
          console.log(error + ": unable to login");
          return throwError(error);
        })
      );
  }


  logout() {
    localStorage.setItem('token', 'false');
    console.log('Logout successful');
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('token') !== null;
  }
}
