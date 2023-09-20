import { Component , EventEmitter, Input, OnInit, Output} from '@angular/core';
import { StudentList } from './student-list';

@Component({
  selector: 'app-directives-demo',
  templateUrl: './directives-demo.component.html',
  styleUrls: ['./directives-demo.component.scss']
})
export class DirectivesDemoComponent implements OnInit  {

  check : boolean = true;

  studentList! : StudentList[]; 

  loggedAs : string  = "user";

  fullName : string = "NANI BABU";

  @Input() childData! : string; // displaying data in child component by importing data from parent component.
  @Output() myEvent = new EventEmitter<string>();

  
  constructor(){
     
  }

  ngOnInit() {

    this.studentList =  [
      {
          "id": 1,
          "name" : "Nani",
          "branch":"cse",
          "pass":true      
      },
      {
         "id":2,
         "name":"Pinky",
         "branch":"Ece",
         "pass":true
      },
      {
        "id":3,
        "name":"divya",
        "branch": "eee",
        "pass":false,
  
      },
      {
        "id":4,
        "name":"rajesh",
        "branch": "civil",
        "pass":false,
  
      }
    ];
  
  }
  callingEvent(){
    this.myEvent.emit('Event data from child directive-demo.component.ts');
  }

  
}
