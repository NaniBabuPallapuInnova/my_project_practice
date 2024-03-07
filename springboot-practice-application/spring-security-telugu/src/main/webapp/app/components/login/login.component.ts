import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthserviceService } from '../../services/authservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  loginFormGroup! : FormGroup;

  username : string = '';
  password : string = '';

  constructor(private formBuilder : FormBuilder, private authService : AuthserviceService, private router : Router){

  }

  ngOnInit() {
    
    this.loginFormGroup = this.formBuilder.group({
        empId_ : ['', [Validators.required]],
        password_ : ['', [Validators.required]]
    })
  }


  submitCredentials(){

    this.username  = this.loginFormGroup.controls['empId_'].value;
    this.password =  this.loginFormGroup.controls['password_'].value
    console.log("username : "+this.username, "password : "+this.password);
    this.authService.login(this.username, this.password).subscribe( data =>{
      console.log('logging login value : '+data);
      if(data.status === 'success'){
        localStorage.setItem('token', 'true');
        this.router.navigate(['/home']);
      } else{
        localStorage.setItem('token', 'false');
        this.router.navigate(['/login']);
      }
    })

  }

}
