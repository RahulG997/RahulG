import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {
  vendor : Observable<Vendor[]>
  vendor1 : Observable<Vendor>
  venId : number;
  show() {
    this.vendor1=this.vendorService.searchVendor(this.venId);
  }

  constructor(private vendorService : VendorService) { 
    this.vendor=vendorService.showVendor();
    this.vendor1=vendorService.searchVendor(this.venId);
  }

  ngOnInit() {
  }

}