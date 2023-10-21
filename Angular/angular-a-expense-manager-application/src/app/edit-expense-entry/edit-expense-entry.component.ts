import { Component, OnInit } from '@angular/core';
import { ExpenseEntry } from '../expense-entry';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ExpenseEntryService } from '../expense-entry.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-expense-entry',
  templateUrl: './edit-expense-entry.component.html',
  styleUrls: ['./edit-expense-entry.component.scss']
})
export class EditExpenseEntryComponent implements OnInit {

  updatedExpenseEntry: ExpenseEntry = {} as ExpenseEntry; // it will used to store updated data from the template form.

  formData!: FormGroup;
  selectedId!: number;
  expenseEntry!: ExpenseEntry; // it will be used to store the fetched data from server API


  constructor(private expenseEntryService: ExpenseEntryService, private activatedRoute: ActivatedRoute, private router: Router) {

  }
  ngOnInit() {

    this.formData = new FormGroup({

      id_: new FormControl(),
      item_: new FormControl('', [Validators.required]),
      amount_: new FormControl('', [Validators.required]),
      category_: new FormControl('', [Validators.required]),
      place_: new FormControl(),
      spendOn_: new FormControl(),
      createdOn_: new FormControl()

    });

    // if selectedId is not null or not zero, it will fetch expenseEntry details based on Id.
    // then fetched expenseEntry details will be updated by new entered data by user in formData.
    this.selectedId = Number(this.activatedRoute.snapshot.paramMap.get('id'));

    if (this.selectedId !== null && this.selectedId !== 0) {
      this.expenseEntryService.getExpenseEntry(this.selectedId).subscribe((data) => {
        this.expenseEntry = data;

        this.formData.controls['id_'].setValue(this.expenseEntry.id);
        this.formData.controls['item_'].setValue(this.expenseEntry.item);
        this.formData.controls['amount_'].setValue(this.expenseEntry.amount);
        this.formData.controls['category_'].setValue(this.expenseEntry.category);
        this.formData.controls['place_'].setValue(this.expenseEntry.place);
        this.formData.controls['spendOn_'].setValue(this.expenseEntry.spendOn);
        this.formData.controls['createdOn_'].setValue(this.expenseEntry.createdOn);

      });
    }

  }

  get itemValue() {
    return this.formData.get('item_'); // only for required validations.
  }

  get amountValue() {
    return this.formData.get('amount_'); // only for required validations.
  }

  get categoryValue() {
    return this.formData.get('category_'); // only for required validations.
  }


  onSubmitData(data: any) {
    console.log("onSubmitData is clicked !" + this.updatedExpenseEntry);
    console.log("onSubmitData is clicked !" + data);
    this.updatedExpenseEntry.id = data['id_'];
    this.updatedExpenseEntry.item = data['item_'];
    this.updatedExpenseEntry.amount = data['amount_'];
    this.updatedExpenseEntry.category = data['category_'];
    this.updatedExpenseEntry.place = data['place_'];
    this.updatedExpenseEntry.spendOn = data['spendOn_'];
    this.updatedExpenseEntry.createdOn = new Date(2023, 5, 26);




    console.log("updatedExpenseEntry :  !" + this.updatedExpenseEntry);

    // if expenseEntry is , we are adding it into list and navigate to expenses list
    // if it is existing entry , we are updating it and navigate to expenses list.
    if (this.updatedExpenseEntry.id === null || this.updatedExpenseEntry.id === 0) {
      console.log("adding the expense entry " + this.updatedExpenseEntry)

      this.expenseEntryService.addExpenseEntry(this.updatedExpenseEntry).subscribe(data => {
        console.log(data);
        this.router.navigate(['/expenses']);
      });
    } else {
      if (this.updatedExpenseEntry.id !== null && this.selectedId !== null && this.updatedExpenseEntry.id === this.selectedId) {
        console.log("updating the existing expense entry " + this.updatedExpenseEntry)
        this.expenseEntryService.updateExpenseEntry(this.updatedExpenseEntry).subscribe(data => {
          console.log(data);
          this.router.navigate(['/expenses']);

        });
      }
    }



  }



}

/*

 Created a form, formData in the ngOnInit method using FormControl and 
FormGroup classes with proper validation rules.
 Loaded the expense entry to be edited in the ngOnInit method.
 Created two methods, itemValue and amountValue to get the item and amount 
values respectively entered by user for the validation purpose.
 Created method, onClickSubmit to save (add / update) the expense entry.
 Used Expense service to add and update expense entries.

*/