import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../interfaces/employee';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { Page } from '../../interfaces/page';
import { PaginationInstance, PaginationService } from 'ngx-pagination';
import { AuthserviceService } from '../../services/authservice.service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrls: ['./employees-list.component.scss']
})
export class EmployeesListComponent implements OnInit {

  // Initialize employeesListData with default values for its properties
  employeesListPageData!: Page<Employee>;

  currentPage = 1;
  pageSize = 5;
  totalPages = 0;

  loggedIn  : boolean = false;


  constructor(private employeeService: EmployeeService, private authService : AuthserviceService, private router : Router) {

  }
  ngOnInit() {

     this.loggedIn = this.authService.isLoggedIn();
          

    this.getEmployeesList();
  }




  getEmployeesList() {


    this.employeeService.getEmployeesList(this.currentPage - 1, this.pageSize).subscribe((data) => {
      this.employeesListPageData = data;
      console.log('fetched employeesssss', JSON.stringify(this.employeesListPageData));
      this.totalPages = data.totalPages;
    });

  }






  deleteEmployeeById(id: number) {

    const fetchedId = Number(id);
    console.log('printing number ' + id);

    this.employeeService.deleteEmployeeById(fetchedId).subscribe((data) => {
      console.log('deleting ', data)
      console.log('employee has been deleted', id);
    });

    window.alert('Employee Has Been Delete Sucessfully employee :' + id);
    this.getEmployeesList();
  }

  previousPage(){
    if(this.currentPage > 1){
      this.currentPage --;
      this.getEmployeesList();
    }
  }

  nextPage(){

    if(this.currentPage < this.totalPages){
      this.currentPage++;
      this.getEmployeesList();
    }
  }


  
  logout(){
    this.authService.logout();
    this.router.navigate(['/login']);
    
  }
  



}
