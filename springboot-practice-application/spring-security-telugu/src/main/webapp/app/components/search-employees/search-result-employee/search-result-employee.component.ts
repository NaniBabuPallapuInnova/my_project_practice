import { Component, Input, OnInit } from '@angular/core';
import { Employee } from '../../../interfaces/employee';

@Component({
  selector: 'app-search-result-employee',
  templateUrl: './search-result-employee.component.html',
  styleUrls: ['./search-result-employee.component.scss']
})
export class SearchResultEmployeeComponent implements OnInit{



  @Input()inputData : Employee = {} as Employee;



  ngOnInit() {


    console.log('printing inputData from result : '+JSON.stringify(this.inputData));
  }
}
