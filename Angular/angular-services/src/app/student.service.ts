import { Injectable, OnInit } from '@angular/core';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService implements OnInit {


  studentData!: Student[];

  constructor() { }
  ngOnInit() {
 
  }


  getEmployees() {
    return this.studentData = [
      {
        "id": 1,
        "name": "Nani",
        "branch": "cse",
        "pass": true
      },
      {
        "id": 2,
        "name": "Pinky",
        "branch": "Ece",
        "pass": true
      },
      {
        "id": 3,
        "name": "divya",
        "branch": "eee",
        "pass": false,

      },
      {
        "id": 4,
        "name": "rajesh",
        "branch": "civil",
        "pass": false,

      }
    ];
  }
}
