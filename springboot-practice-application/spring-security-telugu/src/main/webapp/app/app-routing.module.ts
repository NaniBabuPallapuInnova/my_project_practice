import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';

const routes: Routes = [
  {
    path : '', component : EmployeesListComponent,
  },
  {
    path: 'create', component : CreateEmployeeComponent,
  },
  {
    path: 'show/:id', component : EmployeeDetailsComponent
  },
  {
    path: 'update/:id', component : CreateEmployeeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
