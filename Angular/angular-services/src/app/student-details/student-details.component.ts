import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.scss']
})
export class StudentDetailsComponent implements OnInit {

  public studentDetails! : Student[];

  show : boolean = true;

  constructor(private studentService : StudentService) {

  }
  ngOnInit() {
      this.studentDetails = this.studentService.getEmployees();
  }

  showDetails(){
    this.show = !this.show;
  }

}
