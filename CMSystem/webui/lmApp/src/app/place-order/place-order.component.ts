import { Component, OnInit } from '@angular/core';
import { Orders } from '../orders';
import { Customer } from '../customer';
import { Menu } from '../menu';
import { Observable } from 'rxjs';
import { MenuService } from '../menu.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';
import { CustomerService } from '../customer.service';
@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {

  customer : Customer;
  menuList : Observable<Menu[]>;
  vendorList : Observable<Vendor[]>;
  walletList : Observable<Wallet[]>;
  result : string;
  menuFound : Menu;
  price : number;
  constructor(private _menuService : MenuService, private _vendorService : VendorService, private _walletService : WalletService, private _customerService : CustomerService) {
    this.customer = localStorage.getItem('customer')? JSON.parse(localStorage.getItem('customer')):[];
    this.model.cusId=this.customer.cusId;
    this.menuList = _menuService.showMenu();
    this.vendorList = _vendorService.showVendor();
    this.walletList=_walletService.showByWalletCustomerId(this.customer.cusId);
    this.menu.foodName="Dosa";
   }
   showAmount() {
    //  alert("Hi");
    // alert(this.menu.menName);
    let menId : number;
    menId=parseInt(this.menu.foodName);
    this._menuService.searchMenu(menId).subscribe(x => {
      this.menuFound = x;
      this.price=x.foodPrice;
    });
    // this.price = this.menuFound.menPrice;
   }
   placeOrder() {
    
    // alert(this.model.cusId);
    // alert(this.menu.foodName);
    // alert(this.vendor.venName);
    // alert(this.menuFound.foodPrice);
    this.model.foodId=parseInt(this.menu.foodName);
    this.model.venId=parseInt(this.vendor.venName);
    this.model.walType = this.wallet.walType;
    this._customerService.placeOrder(this.model).subscribe(x => {
      this.result = x;
    })
   }
  model = new Orders();
  menu = new Menu();
  vendor = new Vendor();
  wallet = new Wallet();
  ngOnInit() {
  }

}
