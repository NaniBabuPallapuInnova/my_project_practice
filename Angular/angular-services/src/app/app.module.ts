import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { FormsModule } from '@angular/forms';
import { StudentService } from './student.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
    
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
