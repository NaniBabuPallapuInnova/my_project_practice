import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../interfaces/employee';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent implements OnInit {

  fetchedId :number = 0;

  @Input() employeeDetails : Employee = {} as Employee;

  constructor(private activatedRoute : ActivatedRoute, private employeeService : EmployeeService){

  }

  ngOnInit() {
    
    this.activatedRoute.params.subscribe(param => {
       this.fetchedId = param['id'];
    })

    this.getEmployeeDetails(this.fetchedId);
  }

  getEmployeeDetails(id : number){

    this.employeeService.getEmployeeById(id).subscribe((data) => {
      this.employeeDetails = data;
      console.log("Employee Detaiols : ", this.employeeDetails);
    });
  }
}
