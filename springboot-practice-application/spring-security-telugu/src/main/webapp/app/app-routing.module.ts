import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';
import { SearchResultEmployeeComponent } from './components/search-employees/search-result-employee/search-result-employee.component';
import { SearchEmployeesComponent } from './components/search-employees/search-employees.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {
    path : 'home', component : EmployeesListComponent, canActivate : [AuthGuard],
  },
  {
    path : 'login', component : LoginComponent
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
  ,
  {
    path: 'search', component : SearchEmployeesComponent
  },
  {
    path: '', redirectTo : 'login', pathMatch : 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
