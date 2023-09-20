import { Component , OnInit} from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent {

  value1: string | undefined = "Test Application";

  showData($event: any) {
      alert("Button is clicked");
      if($event){
        alert($event.target);
        alert($event.target.value);

      }
  }

  userName : string|undefined = "Nani Babu";

  imageUrl = "C:\Users\nanibabu.pallapu\Pictures\Screenshots\Screenshot (1).png";

  valueDisabled = true;

  MyClass = "red";

  MyStyles  = true; // if value is true, blue color will be added to text, if it is false , blur color will not be added to text.

  fullName : string | undefined = "Nani Babu Pallapu";

 }
