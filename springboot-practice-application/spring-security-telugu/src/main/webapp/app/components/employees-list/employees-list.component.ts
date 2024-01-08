import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../interfaces/employee';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.scss']
})
export class EmployeesListComponent implements OnInit{

  employeesListData: Employee[] = [];

  constructor(private employeeService : EmployeeService,){

  }
  ngOnInit( ) {

    this.getEmployeesList();
  }

  
 

  getEmployeesList(){
    
    
    this.employeeService.getEmployeesList().subscribe((data) => {
      this.employeesListData = data;
      console.log('fetched employees', JSON.stringify(this.employeesListData));
    });


  }



  deleteEmployeeById(id : number){

    const fetchedId = Number(id);
    console.log('printing number '+ id);
    
    this.employeeService.deleteEmployeeById(fetchedId).subscribe((data) => {
      console.log('deleting ', data)
      console.log('employee has been deleted',id);
    });

    window.alert('Employee Has Been Delete Sucessfully employee :'+id);
    this.employeeService.redirectTo('/');

  }


  




  
}
