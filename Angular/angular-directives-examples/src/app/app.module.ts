import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DirectivesDemoComponent } from './directives-demo/directives-demo.component';
import { FormsModule } from '@angular/forms';
import { CustomDirectiveExampleDirective } from './custom-directive-example.directive';

@NgModule({
  declarations: [
    AppComponent,
    DirectivesDemoComponent,
    CustomDirectiveExampleDirective
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
