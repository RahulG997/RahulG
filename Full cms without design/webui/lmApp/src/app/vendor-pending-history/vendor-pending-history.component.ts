import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Observable} from 'rxjs';
import 'rxjs/add/observable/of';
import {Router, ActivatedRoute} from '@angular/router';
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
  ordId : number;
  vendor : Vendor;
  orders : Observable<Orders[]>;
  selValue : number;
  values : string;
  filter : string[];
  feature = 'Feature 1'
  arr : [];
  rs : string;
  status : string;
  selectedFeatures: any = [];
  acceptOrReject(ordId, venId) {
    alert(ordId);
    alert(venId);
    localStorage.setItem("cancelOrderId",ordId);
    localStorage.setItem("cancelVenId", venId);
    // localStorage.setItem("AcceptOrRejectStatus", status);
    this._router.navigate(['../vendor-acceptedor-rejected-order'], {relativeTo: this._route});
  }
  constructor(private vendorService : VendorService, private _route : ActivatedRoute,private _router : Router){
    this.vendor = localStorage.getItem('vendor')? JSON.parse(localStorage.getItem('vendor')):[];
    //alert("Vendor Id is " +this.vendor.venId);
    this.orders=this.vendorService.pendingHistory(this.vendor.venId);
    
   }
  
  checkIfAllSelected(x) {
    this.selectedFeatures.push(x);
    // alert("added");
  }
  cancelMe() {
    this.values = this.selectedFeatures.toString();
    // alert(this.values);
    this.filter = this.values.split(",");
    this.status="ACCEPTED";
    for(var v=0;v<this.filter.length;v++) {
      alert(this.filter[v]);
      this.vendorService.acceptOrReject(parseInt(this.filter[v]),this.vendor.venId,this.status).subscribe(x => {
        this.rs=x;
      })
    }
    alert("selected orders accepted sucessfully");
    this._router.navigate(['/vendorDashBoard']);
    alert(this.vendor.venId);

  }
  ngOnInit() {
  }

}


