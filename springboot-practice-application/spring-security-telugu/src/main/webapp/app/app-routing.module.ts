import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';
import { SearchResultEmployeeComponent } from './components/search-employees/search-result-employee/search-result-employee.component';
import { SearchEmployeesComponent } from './components/search-employees/search-employees.component';
import { AdminComponent } from './components/admin/admin.component';
import { UserComponent } from './components/user/user.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './auth/auth.guard';

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
  ,
  {
    path: 'search', component : SearchEmployeesComponent
  },
  {
    path:'admin', component : AdminComponent, canActivate : [AuthGuard], data : {roles : ['admin']}
  },
  {
    path:'user', component : UserComponent, canActivate : [AuthGuard], data : {roles : ['user']}
  },
  {
    path:'forbidden', component : ForbiddenComponent
  },
  {
    path:'login', component : LoginComponent
  },{
    path : 'home', component : HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
