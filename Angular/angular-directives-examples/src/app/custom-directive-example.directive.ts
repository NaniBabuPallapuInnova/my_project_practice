import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appCustomDirectiveExample]'
})
export class CustomDirectiveExampleDirective {

  constructor(private e1 : ElementRef) { 
      this.e1.nativeElement.style.backgroundColor='orange';
  }

}
