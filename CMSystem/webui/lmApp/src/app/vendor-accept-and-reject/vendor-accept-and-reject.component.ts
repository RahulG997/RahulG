import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendor-accept-and-reject',
  templateUrl: './vendor-accept-and-reject.component.html',
  styleUrls: ['./vendor-accept-and-reject.component.css']
})
export class VendorAcceptAndRejectComponent implements OnInit {
  vendId : number;
  orderId : number;
  status : string;
  result : string;

  constructor(private _vendorService : VendorService) { }
  acceptOrReject() {
    this._vendorService.acceptOrReject(this.orderId,this.vendId,this.status).subscribe(x => {
      this.result=x;
    })
  }

  ngOnInit() {
  }

}

