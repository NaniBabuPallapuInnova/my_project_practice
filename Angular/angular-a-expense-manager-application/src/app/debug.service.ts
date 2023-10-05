import { Injectable } from '@angular/core';
/**
 * @Injectable decorator is attached to DebugService class, which enables the DebugService to be used in Angular component of the application.
 * providerIn :  option and its value, root enables the DebugService to be used in all component of the application.
 * 
 */
@Injectable({
  providedIn: 'root'
})
export class DebugService {

  constructor() { }

  info(message:string):void{

    console.log(message);
  }
}
