import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-directives-examples';

  parentData : string = 'Data from Parent Component app.component.ts file';

  childDataOutput!: string;

  handlingEvent(data : string){
    this.childDataOutput = data;
  }
  
}
