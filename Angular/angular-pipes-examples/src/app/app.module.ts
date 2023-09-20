import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SquarerootPipe } from './squareroot.pipe';
import { DigitscountPipe } from './digitscount.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SquarerootPipe,
    DigitscountPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
