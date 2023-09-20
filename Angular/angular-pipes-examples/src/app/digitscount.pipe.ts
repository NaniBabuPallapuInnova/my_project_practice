import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'digitscount'
})
export class DigitscountPipe implements PipeTransform {

  transform(value: number): number {
    return value.toString().length;
  }

}
