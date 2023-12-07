import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../interfaces/customer';

@Component({
  selector: 'app-display-customer',
  templateUrl: './display-customer.component.html',
  styleUrls: ['./display-customer.component.scss']
})
export class DisplayCustomerComponent implements OnInit{

  fetchedCustomersList: Customer[] = [];

  showTableFlag : boolean = false;

  constructor(private customerService : CustomerService){

  }

  ngOnInit() {
    this.getAllCustomers();
  }

  getAllCustomers(){
    this.customerService.getCustomers().subscribe((data) => {
      this.fetchedCustomersList = data;
      console.log("printing customers list :" +JSON.stringify(this.fetchedCustomersList));
    })
  }


  showTable(){
    this.showTableFlag = !this.showTableFlag;
  }
}
