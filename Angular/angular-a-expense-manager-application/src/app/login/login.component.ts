import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthorizationService } from '../authorization.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userName! : string;
  password! : string;
  formData! : FormGroup;

  constructor(private authorizationService : AuthorizationService, private router : Router){

  }


  ngOnInit(){
    this.formData = new FormGroup({
      username_ : new FormControl('admin'),
      password_ : new FormControl('')
    });
  }

  onClickSubmit(data : any){
    this.userName = data.username_;
    this.password = data.password_;

    this.authorizationService.login(this.userName, this.password).subscribe(data => {

      console.log("Log In Successful");

      if(data){
        this.router.navigate(['/expenses']);
      }
    });
  }

}
