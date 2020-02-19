import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Observable} from 'rxjs';
import 'rxjs/add/observable/of';
import {Router} from '@angular/router';
import { Customer } from '../customer';


@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {

  customerName : string;
  custId : number;
  customer : Observable<Customer>;
  cust : Customer;
  constructor(private customerService : CustomerService) {
    this.customerService.findByCustomerName(localStorage.getItem("user")).subscribe(x => {
      this.cust=x;
      localStorage.setItem('customer', JSON.stringify(x));
    });
   }
  ngOnInit() {
    this.customer = this.customerService.findByCustomerName(localStorage.getItem("user"));
    // localStorage.setItem('customer', JSON.stringify(this.customer));
    
    // alert("Customer Id is  " +this.customer.);
  }

}
