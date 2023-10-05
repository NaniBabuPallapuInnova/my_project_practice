import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DisplayUserComponent } from './user/display-user/display-user.component';
import { CreateUserComponent } from './user/create-user/create-user.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayUserComponent,
    CreateUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
