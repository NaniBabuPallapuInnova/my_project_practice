import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {

  studentList!: Student[];
  show : boolean = true
  isDisable : boolean = false;
  public errorMsg : any;
  constructor(private studentService : StudentService) {

  }

// 3. Subscribe to the observables from EmployeeList and EmployeeDetails.
// 4. Assign the Employee Array to the local variables.
  ngOnInit() {
    this.studentService.getEmployees().subscribe(data => this.studentList = data,
        error => this.errorMsg = error
      )
  }

  showStudents(){
    this.show = !this.show;
  }
}
