import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Angular Practice Programs';

   data : number =0;

    count : number =0;

    constructor(){

    }

  findPrimeOrNot(value : number){
    
    alert("given number =  "+value);


    for(let i=2;i<=value/2;i++){
      if(value%i===0){
        this.count++;
      }
    }

    if(this.count === 0){
      alert(value + "  is a prime number");
    } else{
      alert(value + "  is not a prime number")
    }


  }
}
