import { Component } from '@angular/core';
import { Student } from './student';
import { StudentService } from './student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Template Driven Forms';

  topicHasError: boolean = true;

  public submitted : boolean = false;

  public topics = ['Python', 'Java', 'Devops'];

  public student = new Student('NaniBabu', 'nanipallapu369@gmail.com', 9392590089, 'default', 'morning', true);

  constructor(private studentService : StudentService){

  }

  validateTopic(value: string) {
    if (value == 'default') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }

  onSubmitt(){
    console.log(this.student);
    this.submitted = true;
    this.studentService.enroll(this.student).subscribe(
      data => console.log('Printed Successfully', data),
      error => console.log('error occured!', error)
    );

  }
}
