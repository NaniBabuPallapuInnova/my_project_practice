import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-pipes-examples';

  fullName : string = 'Nani Babu';

  todayDate  = new Date();

  sampleJsonData = {
    name : 'Nani Babu',
    age : '25',
    job : 'Software Engineer',
    address : {
      village : 'uppaluru',
      city : 'Vijayawada',
      district : 'Krishna District',
      state : 'Andhra Pradesh',
      pincode : '521151'
    }
  }

  days = ['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'];
}
