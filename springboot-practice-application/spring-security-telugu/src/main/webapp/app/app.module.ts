import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { SearchEmployeesComponent } from './components/search-employees/search-employees.component';
import { SearchResultEmployeeComponent } from './components/search-employees/search-result-employee/search-result-employee.component'
import { NgxPaginationModule } from 'ngx-pagination';
import { AdminComponent } from './components/admin/admin.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { HomeComponent } from './components/home/home.component';
import { AuthGuard } from './auth/auth.guard';
import { AuthInterceptor } from './auth/auth.interceptor';
import { LoginComponent } from './components/login/login.component';
import { UserComponent } from './components/user/user.component';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesListComponent,
    EmployeeDetailsComponent,
    CreateEmployeeComponent,
    SearchEmployeesComponent,
    SearchResultEmployeeComponent,
    AdminComponent,
    UserComponent,
    ForbiddenComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,

  ],
  providers: [
    AuthGuard,
    {
      provide : HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true
    },
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
