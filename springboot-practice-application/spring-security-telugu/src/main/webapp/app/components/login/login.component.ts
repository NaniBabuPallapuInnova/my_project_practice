import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { UserAuthService } from '../../services/user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private userAuthService: UserAuthService, private router :Router ) {

  }

  ngOnInit() {

  }


  login(logInForm: NgForm) {
    console.log('login form has been submitted' + JSON.stringify(logInForm.value));
  
    this.userService.login(logInForm.value).subscribe(
      (response: any) => {

        console.log("printing token : " + response.jwtToken);
        console.log("printing roles :"+JSON.stringify(response.user.roles));

        this.userAuthService.setRoles(response.user.roles);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.user.roles[0].roleName;

        if(role === 'admin'){

          this.router.navigate(['/admin']);
        } else if(role === 'user'){
          this.router.navigate(['/user']);
        } else{
          this.router.navigate(['/forbidden']);
        }
        
      },
      (error) => {
        console.log("Login Failed Due to Error : " + JSON.stringify(error));
      }
    );
  }
  
}
