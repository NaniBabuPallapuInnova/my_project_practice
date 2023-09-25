import { Component } from '@angular/core';
import { Student } from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Template Driven Forms';

  public topics = ['Python','Java','Devops'];

  public student = new Student('NaniBabu','nanipallapu369@gmail.com',9392590089,'','morning',true);
}
