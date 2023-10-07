import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { AuthorizationService } from './authorization.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Expense Manager';
  isUserLoggedIn = false;


  constructor(private authService : AuthorizationService){

  }
  ngOnInit() {

    let storeData = localStorage.getItem("isUserLoggedIn");
    console.log("Store Data "+storeData);
    
    
    if(storeData!==null && storeData === "true"){
      this.isUserLoggedIn=true;
    } else{
      this.isUserLoggedIn=false;
    }
  }

}
