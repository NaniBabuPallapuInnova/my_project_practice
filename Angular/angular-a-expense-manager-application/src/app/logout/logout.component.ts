import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../authorization.service';
import { Router } from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';


@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {


  constructor(private authorizationService : AuthorizationService, private router : Router){

  }
  ngOnInit(){

    // Used logout method of AuthService.Once the user is logged out, the page will redirect to home page (/).
    
    this.authorizationService.logout();

    this.router.navigate(['/']);
    
  }

}
