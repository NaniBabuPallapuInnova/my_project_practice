import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExpenseEntryComponent } from './expense-entry/expense-entry.component';
import { ExpenseEntryListComponent } from './expense-entry-list/expense-entry-list.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ExpenseGuard } from './expense.guard';
import { AboutComponent } from './about/about.component';
import { EditExpenseEntryComponent } from './edit-expense-entry/edit-expense-entry.component';

/**
 * -> Created two new routes, login and logout to access LoginComponent and LogoutComponent respectively.
 * -> Add new option canActivate for ExpenseEntryComponent and ExpenseEntryListComponent
 */
const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'login', component: LoginComponent },
  { path: 'expenses', component: ExpenseEntryListComponent, canActivate: [ExpenseGuard] },
  { path: 'expense/detail/:id', component: ExpenseEntryComponent, canActivate: [ExpenseGuard] },
  { path: 'expenses/add', component: EditExpenseEntryComponent, canActivate: [ExpenseGuard] },
  { path: 'expenses/edit/:id', component: EditExpenseEntryComponent, canActivate: [ExpenseGuard] },
  { path: '', redirectTo: 'expenses', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

