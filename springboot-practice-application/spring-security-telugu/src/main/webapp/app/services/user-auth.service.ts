import { Injectable } from '@angular/core';
/**
 * 
 */
@Injectable({
  providedIn: 'root'
})
export class UserAuthService {



  constructor() { 

  }


  public setRoles(roles : []) : void{
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles(): [] | null{

    const rolesString = localStorage.getItem('roles');
    if(rolesString &&rolesString !== null){
      return JSON.parse(rolesString) as [];
    } else{
      return null;
    }

  }


  public setToken(jwtToken : string):void{
    localStorage.setItem('jwtToken', jwtToken);
  }

  public getToken(): string | null{

    const token = localStorage.getItem('jwtToken');
    if(token && token !== null){
      return token;
    } else{
      return null;
    }
  }

  public clear(){
    localStorage.clear();
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('roles');
  }

  public isLoggedIn():boolean{
    return this.getRoles() !== null  && this.getToken() !== null;
  }


}
