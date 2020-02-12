import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Observable} from 'rxjs';
import 'rxjs/add/observable/of';
import {Router} from '@angular/router';
import { Orders } from '../orders';
import { Vendor } from '../vendor';


@Component({
  selector: 'app-vendor-pending-history',
  templateUrl: './vendor-pending-history.component.html',
  styleUrls: ['./vendor-pending-history.component.css']
})
export class VendorPendingHistoryComponent implements OnInit {

  vendorName : string;
  venId : number;
  vendor : Vendor;
  orders : Observable<Orders[]>;
  constructor(private vendorService : VendorService) {
    this.vendor = localStorage.getItem('vendor')? JSON.parse(localStorage.getItem('vendor')):[];
    //alert("Vendor Id is " +this.vendor.venId);
    this.orders=this.vendorService.pendingHistory(this.vendor.venId);
    
   }

  ngOnInit() {
  }


}
