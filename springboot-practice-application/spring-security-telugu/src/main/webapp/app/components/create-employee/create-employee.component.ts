import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Employee } from '../../interfaces/employee';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.scss']
})
export class CreateEmployeeComponent implements OnInit{

  newEmployee: Employee = {} as Employee;
  fetchedId : number = 0;

  employeeFormGroup! : FormGroup;

  constructor(private formBuilder :FormBuilder, private employeeService : EmployeeService, private router : Router, private activatedRoute : ActivatedRoute, private location : Location){

  }
  ngOnInit(){


    

    this.employeeFormGroup = this.formBuilder.group({

      name_ : ['', [ Validators.required]],
      email_ : ['', [Validators.email,Validators.required]],
      password_:['', [Validators.required]],
      phone_ : ['', [Validators.maxLength(10)]],
      salary_ : ['', [ Validators.required]],
      doj_ : ['', [Validators.required]]
    });

    this.activatedRoute.params.subscribe(param => {
      let id = Number(param['id']);
      this.fetchedId = Number.isNaN(id) ? 0 : id;
      console.log('print id : '+this.fetchedId)

    })

    if(this.fetchedId !== null && this.fetchedId !== 0){
      this.fetchAndInitializeValuesForUpdating(this.fetchedId);

    }

  }


  registerEmployee(){
    
    if(this.newEmployee){
      this.newEmployee.name = this.employeeFormGroup.controls['name_'].value;
      this.newEmployee.email = this.employeeFormGroup.controls['email_'].value;
      this.newEmployee.password = this.employeeFormGroup.controls['password_'].value;
      this.newEmployee.phone = this.employeeFormGroup.controls['phone_'].value;
      this.newEmployee.salary = this.employeeFormGroup.controls['salary_'].value;
      this.newEmployee.dateOfJoining = this.employeeFormGroup.controls['doj_'].value;
  
      this.employeeService.createEmployee(this.newEmployee).subscribe((data) =>{
        console.log("Employee has been created", data);
      })
    }


    this.location.back();
  }


  fetchAndInitializeValuesForUpdating(id : number){

    this.employeeService.getEmployeeById(id).subscribe((data) => {

      this.newEmployee = data;

      console.log('Fetched Employee Details Based On Id'+id+ "   "+JSON.stringify(this.newEmployee));

      this.employeeFormGroup.controls['name_'].setValue(data.name);
      this.employeeFormGroup.controls['email_'].setValue(data.email);
      this.employeeFormGroup.controls['password_'].setValue(data.password);
      this.employeeFormGroup.controls['phone_'].setValue(data.phone);
      this.employeeFormGroup.controls['salary_'].setValue(data.salary);
      this.employeeFormGroup.controls['doj_'].setValue(data.dateOfJoining);
    });
  }

}
