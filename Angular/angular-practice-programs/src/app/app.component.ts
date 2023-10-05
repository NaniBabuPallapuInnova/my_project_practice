import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'Angular Practice Programs';

   data! : number;

   count : number=0;

   show : boolean = true;

    constructor(){

    }
  ngOnInit(){
    this.data = 0; // Initial value
  }

 

  findPrimeOrNot(value : number){
    
    this.show=!this.show;


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
