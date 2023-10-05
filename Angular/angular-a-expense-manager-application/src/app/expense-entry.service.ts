import { Injectable } from '@angular/core';
import { ExpenseEntry } from './expense-entry';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';


// ExpenseEntryService will get the latest expense entries, insert new expense entries, modify existing expense entries and delete the unwanted expense entries.

@Injectable({
  providedIn: 'root'
})
export class ExpenseEntryService {

  // Create a variable, expenseRestUrl to specify the Expense Rest API endpoints.
  private expenseRestUrl = 'http://localhost:8008/api/expense';
  // private expenseRestUrl = 'api/expense';



  //Create a variable, httpOptions to set the Http Header option. This will be used during the Http Rest API call by Angular HttpClient service.
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  //Inject the HttpClient service into our service.

  constructor(private httpClient: HttpClient) {

  }

  /*
  Handling errors or displaying erorrs.
  
  */
  private httpErrorHandler(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error("A client side error occurs. The error message is " + error.message);
    } else {
      console.error("An error happened in server. The HTTP status code is " + error.status + " and the error returned is " + error.message);
    }
    return throwError("Error occurred. Pleas try again");
  }




  /*
    getExpenseEntries() calls the get() method using expense end point and also 
    configures the error handler. Also, it configures httpClient to try for maximum of 
    3 times in case of failure. Finally, it returns the response from server as typed 
    (ExpenseEntry[]) Observable object.
  
  */
  getExpenseEntries(): Observable<ExpenseEntry[]> {
    return this.httpClient.get<ExpenseEntry[]>(this.expenseRestUrl, this.httpOptions)
      .pipe(
        retry(3),
        catchError(this.httpErrorHandler)
      );
  }

  /*
   getExpenseEntry is similar to getExpenseEntries() except it passes the id of 
  the ExpenseEntry object and gets ExpenseEntry Observable object.
  */

  getExpenseEntry(id: number): Observable<ExpenseEntry> {
    return this.httpClient.get<ExpenseEntry>(this.expenseRestUrl + '/' + id, this.httpOptions)
      .pipe(
        retry(3),
        catchError(this.httpErrorHandler)
      );
  }


  /*
  Add Expense functionality
  Let us add a new method, addExpenseEntry() in our ExpenseEntryService to add new 
  expense entry as mentioned below:
  */
  addExpenseEntry(addEntry: ExpenseEntry): Observable<ExpenseEntry> {
    return this.httpClient.post<ExpenseEntry>(this.expenseRestUrl, addEntry, this.httpOptions)
      .pipe(
        retry(3),
        catchError(this.httpErrorHandler)
      );
  }



  /*
  Update Expense functionality
  Let us add a new method, updateExpenseEntry() in our ExpenseEntryService to 
  update existing expense entry as mentioned below:
  */

  updateExpenseEntry(updateEntry: ExpenseEntry): Observable<ExpenseEntry> {
    return this.httpClient.put<ExpenseEntry>(this.expenseRestUrl + '/' + updateEntry.id, updateEntry, this.httpOptions)
      .pipe(
        retry(3),
        catchError(this.httpErrorHandler)
      );
  }



  /*
  Delete expense entry functionality
  Let us add a new method, deleteExpenseEntry() in our ExpenseEntryService to delete 
  existing expense entry as mentioned below:
  */

  deleteExpenseEntry(deleteEntry : ExpenseEntry | number):Observable<ExpenseEntry>{

    const id = typeof deleteEntry == 'number'? deleteEntry : deleteEntry.id;
    const deleteUrl = `${this.expenseRestUrl}/${id}`;
    return this.httpClient.delete<ExpenseEntry>(deleteUrl, this.httpOptions)
    .pipe(
      retry(3),
      catchError(this.httpErrorHandler)
    );
  }


}
