import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable, catchError, throwError } from "rxjs";
import { UserAuthService } from "../services/user-auth.service";
import { Router } from "@angular/router";
import { Injectable } from "@angular/core";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  // Intercepts HTTP requests and adds authorization token if present
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    // Check if request is marked as 'No-Auth'
    if (req.headers.get('No-Auth') === 'True') {
      // If marked as 'No-Auth', pass the request without modification
      return next.handle(req.clone());
    }

    // Retrieve JWT token from user authentication service
    const token = this.userAuthService.getToken();

    // Add token to request headers if available
    if (token !== null) {
      req = this.addToken(req, token);
    }

    // Handle the request and response, catching any errors
    return next.handle(req).pipe(
      catchError((err: HttpErrorResponse) => {
        // Log error status
        console.log(err.status);
        // Redirect to login page if unauthorized (401)
        if (err.status === 401) {
          this.router.navigate(['/login']);
        } 
        // Redirect to forbidden page if forbidden (403)
        else if (err.status === 403) {
          this.router.navigate(['/forbidden']);
        }
        // Return an observable with error message
        return throwError("Something went wrong");
      })
    );
  }

  // Adds authorization token to request headers
  private addToken(request: HttpRequest<any>, token: string) {
    return request.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
  }
}
