import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { DepartmentsComponent } from './departments/departments.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeOverviewComponent } from './employee-overview/employee-overview.component';
import { EmployeeContactComponent } from './employee-contact/employee-contact.component';

const routes: Routes = [
  { path: '', redirectTo: '/departments', pathMatch: 'full' }, // renders if given path is empty

  { path: 'employees', component: EmployeeListComponent }, // renders employee component

  // renders employee-details component
  { 
    
    path: 'employees/:id',
    component: EmployeeDetailsComponent,
    // child routes
    children :[
      {path : 'employee-overview', component : EmployeeOverviewComponent},
      {path : 'employee-contact', component : EmployeeContactComponent}
    ]
  
  }, 
  { path: 'departments', component: DepartmentsComponent }, // renders departments component
  { path: "**", component: PageNotFoundComponent } // // renders page-not-found component if given url does not match above paths
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

export const routingComponents = [EmployeeListComponent, DepartmentsComponent, PageNotFoundComponent, EmployeeOverviewComponent, EmployeeContactComponent];
