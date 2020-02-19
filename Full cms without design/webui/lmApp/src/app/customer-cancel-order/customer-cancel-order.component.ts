import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-cancel-order',
  templateUrl: './customer-cancel-order.component.html',
  styleUrls: ['./customer-cancel-order.component.css']
})
export class CustomerCancelOrderComponent implements OnInit {

  cusId : number;
  ordId : number;
  status : String;
  result : String;

  constructor(private _customerService : CustomerService) { }
  cancel() {
    this._customerService.cancelOrder(this.ordId,this.cusId,this.status).subscribe(x => {
      this.result=x;
    })
  }

  ngOnInit() {
  }


}
