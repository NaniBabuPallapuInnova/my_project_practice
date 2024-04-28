import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserAuthService } from '../services/user-auth.service';
import { UserService } from '../services/user.service';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    private userService: UserService
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {

    //Checks if the user is authenticated by verifying the presence of a token.
    if (this.userAuthService.getToken() !== null) {

      //Extracts the required roles from the route data.
      const role = route.data['roles'] as Array<string>; 

      if (role) {

        // the code checks if the current user has the required role to access a particular route by comparing the user's roles with the allowed roles specified for that route. If a match is found, access is granted; otherwise, the user is redirected to the forbidden page.
        const match = this.userService.matchRole(role);

        if (match) {
          return true;
        } else {
          this.router.navigate(['/forbidden']);
          return false;
        }
      }
    }

    //Navigates to the login page if the user is not authenticated if user does not have token

    this.router.navigate(['/login']);
    return false;
  }
}
