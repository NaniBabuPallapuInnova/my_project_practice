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
  public errorMsg : any;

  constructor(private studentService : StudentService) {

  }
  ngOnInit() {
    this.studentService.getEmployees().subscribe(data => this.studentDetails = data,
      error => this.errorMsg = error
      
      );
  }

  showDetails(){
    this.show = !this.show;
  }

}
