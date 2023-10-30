import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthorizationService } from './authorization.service';

@Injectable({
  providedIn: 'root'
})
export class ExpenseGuard implements CanActivate {

  constructor(private authService: AuthorizationService, private router: Router) {

  }

/*

 checkLogin will check whether the localStorage has the user information and if it 
is available, then it returns true.
 If the user is logged in and goes to login page, it will redirect the user to expenses 
page.
 If the user is not logged in, then the user will be redirected to login page

*/

canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree {
  let url: string = state.url;
  return this.checkLogin(url);

}

checkLogin(url: string): true | UrlTree {
  try {
    console.log("URL: " + url);
 
    let val: string = localStorage.getItem('isUserLoggedIn')!;
    console.log("val1: : "+val)

    if (val !== null && val === "true") {
      if (url === '/login') {
        this.router.navigate(['/expenses']);
        return true; // Return true if the user is logged in and navigates to '/login'.
      } else {

        return true; // Return true if the user is logged in and navigates to any other URL.
      }
    } else {
      return this.router.parseUrl('/login'); // Redirect to '/login' if the user is not logged in.
    }
  } catch (error) {
    console.error(error);
    // Handle any errors here if needed.
    return  this.router.parseUrl('/login'); // Redirect to '/login' in case of an error.
  }
}
 


}
