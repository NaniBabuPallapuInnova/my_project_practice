import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot' // it should be used in template file
})
export class SquarerootPipe implements PipeTransform {

  transform(value: number): number {
    return Math.sqrt(value);
  }

}
