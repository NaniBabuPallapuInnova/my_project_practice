import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService : UserService){

  }

  ngOnInit() {

  }


  login(logInForm : NgForm){
    
    console.log('login form has been sumitted'+JSON.stringify(logInForm.value));

    this.userService.login(logInForm.value).subscribe(response => {
      console.log("Login Successful : "+JSON.stringify(response))
    },

    (error) => {
      console.log("Login Failed Due to Error : "+JSON.stringify(error))

    }

    );

  }
}
