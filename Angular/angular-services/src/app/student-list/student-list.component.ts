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

  constructor(private studentService : StudentService) {

  }

  ngOnInit() {
    this.studentList = this.studentService.getEmployees();
  }

  showStudents(){
    this.show = !this.show;
  }
}
