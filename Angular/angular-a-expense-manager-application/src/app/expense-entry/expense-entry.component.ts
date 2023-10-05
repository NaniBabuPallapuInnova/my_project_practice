import { Component, OnInit } from '@angular/core';
import { ExpenseEntry } from '../expense-entry';
import { ExpenseEntryService } from '../expense-entry.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, switchMap } from 'rxjs';

@Component({
  selector: 'app-expense-entry',
  templateUrl: './expense-entry.component.html',
  styleUrls: ['./expense-entry.component.scss']
})
export class ExpenseEntryComponent implements OnInit {
  title! : string;
  expenseEntry : ExpenseEntry = {} as ExpenseEntry;
  expenseEntry$! : Observable<ExpenseEntry>;
  selectedId! : number;

  constructor(private expenseEntryService : ExpenseEntryService, private router : Router, private activatedRoute:ActivatedRoute){

  }

  ngOnInit(){
    this.title='Expense Entry'

    this.expenseEntry$ =  this.activatedRoute.paramMap.pipe(
      switchMap(params => {
        this.selectedId = Number(params.get('id'));
        return this.expenseEntryService.getExpenseEntry(this.selectedId);
      })
    );

    this.expenseEntry$.subscribe((data) =>this.expenseEntry=data);

  }


  goToList(){
    this.router.navigate(['/expenses']);
  }
}
