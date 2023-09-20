import { Component, OnInit } from '@angular/core';
import { ExpenseEntry } from './expense-entry';


@Component({
  selector: 'app-expense-entry',
  templateUrl: './expense-entry.component.html',
  styleUrls: ['./expense-entry.component.scss']
})



export class ExpenseEntryComponent implements OnInit {
    title : string | undefined;
    expenseEntry! : ExpenseEntry;

    constructor(){
  
    }

    ngOnInit() {
      this.title = "Expense Entry";

      this.expenseEntry = {
        id:1,
        name:"pizza",
        amount:21,
        category:"food",
        location:"zomato",
        spendOn: new Date(2023, 6, 1, 10, 10, 10),
        creationDate : new Date(2023, 6, 1, 10, 10, 10),
      };
    }
}
