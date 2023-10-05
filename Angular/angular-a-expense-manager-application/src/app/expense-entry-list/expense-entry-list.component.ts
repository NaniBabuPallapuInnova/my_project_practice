import { Component, OnInit } from '@angular/core';
import { ExpenseEntry } from '../expense-entry';
import { DebugService } from '../debug.service';
import { ExpenseEntryService } from '../expense-entry.service';

@Component({
  selector: 'app-expense-entry-list',
  templateUrl: './expense-entry-list.component.html',
  styleUrls: ['./expense-entry-list.component.scss'],
  providers: [DebugService] // we have used providers meta data (ElementInjector) to register the service

})
export class ExpenseEntryListComponent implements OnInit {
  title!: string;
  expenseEntryListArray!: ExpenseEntry[];

  constructor(private debugService : DebugService, private expenseEntryService : ExpenseEntryService){

  }

  ngOnInit() {
    this.debugService.info('ExpenseEntryList Component Initialized');
    this.title = 'Expense Entry List'
    this.getExpenseEntriesList();
  }

  // getting ExpenseEntry records from ExpenseEntryService and subscribing the data.
  getExpenseEntriesList(){
    this.expenseEntryService.getExpenseEntries().subscribe((data) =>this.expenseEntryListArray=data);
  }


}
