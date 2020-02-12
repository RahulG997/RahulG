import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vendor-dashboard',
  templateUrl: './vendor-dashboard.component.html',
  styleUrls: ['./vendor-dashboard.component.css']
})
export class VendorDashboardComponent implements OnInit {

  userName : string;
  venId : string;
  
  constructor() { 
    this.userName = localStorage.getItem("venUser");
  this.venId=localStorage.getItem("vid");
 }

  ngOnInit() {
  }

}
