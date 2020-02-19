import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Observable} from 'rxjs';
import 'rxjs/add/observable/of';
 //import {Router} from '@angular/router';
import { Orders } from '../orders';
import { Customer } from '../customer';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-pending-history',
  templateUrl: './customer-pending-history.component.html',
  styleUrls: ['./customer-pending-history.component.css']
})
export class CustomerPendingHistoryComponent implements OnInit {

  customerName : string;
  cusId : number;
  ordId : number;
  customer : Customer;
  orders : Observable<Orders[]>;
  selValue : number;
  values : string;
  filter : string[];
  feature = 'Feature 1'
  arr : [];
  result : string;
  status : string;
  selectedFeatures: any = [];
  constructor(private customerService : CustomerService, private _router : Router, private _route : ActivatedRoute) {
    this.customer = localStorage.getItem('customer')? JSON.parse(localStorage.getItem('customer')):[];
     //alert("Customer Id is " +this.customer.cusId);
     this.orders=this.customerService.pendingHistory(this.customer.cusId);
     
 
   }
   cancelOrder(ordId, custId) {
    // alert(ordId);
    // alert(custId);
    localStorage.setItem("cancelOrderId",ordId);
    localStorage.setItem("cancelCustId", custId);
    this._router.navigate(['../customerCancelOrder'], {relativeTo: this._route});
  }
  checkIfAllSelected(x) {
    this.selectedFeatures.push(x);
    // alert("added");
  }
  cancelMe() {
    this.values = this.selectedFeatures.toString();
    // alert(this.values);
    this.filter = this.values.split(",");
    this.status="YES";
    for(var v=0;v<this.filter.length;v++) {
      alert(this.filter[v]);
      this.customerService.cancelOrder(parseInt(this.filter[v]),this.customer.cusId,this.status).subscribe(x => {
        this.result=x;
      })
    }
    alert("Selected Orders Cancelled Successfully...");
    this._router.navigate(['/dashBoard']);
    alert(this.customer.cusId);

  }

  ngOnInit() {
  }


}
