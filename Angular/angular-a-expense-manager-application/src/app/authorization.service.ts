import { Injectable } from '@angular/core';
import { Observable, delay, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  isUserLoggedIn : boolean = false;

  constructor() { 

  }

  login(userName : string , password : string):Observable<boolean>{
    this.isUserLoggedIn = userName==='admin' && password === 'root';
    localStorage.setItem('isUserLoggedIn', this.isUserLoggedIn ? "true":"false");
    console.log("isUserLoggedIn : "+this.isUserLoggedIn)

    return of(this.isUserLoggedIn).pipe(
      delay(1000),
      tap(val => {
        console.log("Authentication Successful"+val);

      })
    );


  }

  logout():void{
    this.isUserLoggedIn = false;
    localStorage.removeItem('isUserLoggedIn');
  }
}
