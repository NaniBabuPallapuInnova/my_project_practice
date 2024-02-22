import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../interfaces/employee';

@Component({
  selector: 'app-search-employees',
  templateUrl: './search-employees.component.html',
  styleUrls: ['./search-employees.component.scss']
})
export class SearchEmployeesComponent implements OnInit{
  searchKeyword : string = '';

  searchedEmployees : Employee[] = [];


  constructor(private employeeService : EmployeeService){

  }

  ngOnInit(){
    
  }


  searchEmployees(){

    this.employeeService.searchEmployeesBasedOnNameOrEmpId(this.searchKeyword).subscribe((data) => {
      this.searchedEmployees = data;
      console.log('searched employees list : '+JSON.stringify(this.searchedEmployees));
    })

  }

}
