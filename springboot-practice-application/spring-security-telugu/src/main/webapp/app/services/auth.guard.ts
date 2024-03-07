import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthserviceService } from './authservice.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private authService: AuthserviceService) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let currentUrl: string = state.url;

    return this.checkUrlPath(currentUrl);
  }

  checkUrlPath(currentUrl: string): true | UrlTree {
    try {
      console.log("current Url Path : " + currentUrl);

      let storedValue = localStorage.getItem('token');
      if (storedValue !== null && storedValue === "true") {
        if (currentUrl === '/login') {
          this.router.navigate(['/home']);
          return true; // Return true if the user is logged in and navigates to '/login'.
        } else {
          return true; // Return true if the user is logged in and navigates to any other URL.
        }
      } else {
        console.log("User is not found, try again");
        return this.router.parseUrl('/login'); // Redirect to '/login' if the user is not logged in.
      }

    } catch (error) {
      console.error(error);
      return this.router.parseUrl('/login'); // Redirect to '/login' in case of an error.
    }
  }
}