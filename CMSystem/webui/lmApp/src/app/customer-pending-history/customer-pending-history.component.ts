import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Observable} from 'rxjs';
import 'rxjs/add/observable/of';
import {Router} from '@angular/router';
import { Orders } from '../orders';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer-pending-history',
  templateUrl: './customer-pending-history.component.html',
  styleUrls: ['./customer-pending-history.component.css']
})
export class CustomerPendingHistoryComponent implements OnInit {

  customerName : string;
  cusId : number;
  customer : Customer;
  orders : Observable<Orders[]>;
  constructor(private customerService : CustomerService) {
    this.customer = localStorage.getItem('customer')? JSON.parse(localStorage.getItem('customer')):[];
     //alert("Customer Id is " +this.customer.cusId);
     this.orders=this.customerService.pendingHistory(this.customer.cusId);
     
 
   }

  ngOnInit() {
  }


}
