import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { DashBoardComponent } from './dash-board/dash-board.component';
import { CustomerInfoComponent } from './customer-info/customer-info.component';
import { CustomerOrderHistoryComponent } from './customer-order-history/customer-order-history.component';
import { CustomerPendingHistoryComponent } from './customer-pending-history/customer-pending-history.component';
// import { VendorComponent } from './vendor/vendor.component';
import { VendorInfoComponent } from './vendor-info/vendor-info.component';
import { VendorLoginComponent } from './vendor-login/vendor-login.component';
import { VendorOrderHistoryComponent } from './vendor-order-history/vendor-order-history.component';
import { VendorPendingHistoryComponent } from './vendor-pending-history/vendor-pending-history.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { WalletComponent } from './wallet/wallet.component';
import { CustomerCancelOrderComponent } from './customer-cancel-order/customer-cancel-order.component';
import { CMSMainComponent } from './cmsmain/cmsmain.component';
import { VendorAcceptAndRejectComponent } from './vendor-accept-and-reject/vendor-accept-and-reject.component';
import { VendorDashboardComponent } from './vendor-dashboard/vendor-dashboard.component';
import { VendorComponent } from './vendor/vendor.component';

const appRoutes : Routes = [

  {path : 'dashBoard', component : DashBoardComponent,
  children :
  [
    {path:'placeOrder', component:PlaceOrderComponent, outlet:'data'},
    {path:'customerPendingHistory', component:CustomerPendingHistoryComponent, outlet:'data'},
    {path:'customerOrderHistory', component:CustomerOrderHistoryComponent, outlet:'data'},
    {path:'wallet', component:WalletComponent, outlet:'data'},
    {path:'customerCancelOrder', component:CustomerCancelOrderComponent, outlet:'data'},
  ]
},
{path:'vendor-dashboard', component:VendorDashboardComponent,
children :
[
  {path:'vendor', component:VendorComponent, outlet:'data'},
  {path:'pending-orders-vendor', component: VendorPendingHistoryComponent, outlet:'data'},
  {path:'vendor-acceptedor-rejected-order', component: VendorAcceptAndRejectComponent, outlet:'data'},
]
},
{path:'cms-main', component:CMSMainComponent,
children :
[

  {path : 'vendor-login', component : VendorLoginComponent,outlet:'data' },
  {path : 'customer-login', component : CustomerLoginComponent,outlet:'data' },
]
},
  {path : '', component : CMSMainComponent },
]
@NgModule({
  declarations: [
    AppComponent,
    CustomerLoginComponent,
    DashBoardComponent,
    CustomerInfoComponent,
    CustomerOrderHistoryComponent,
    CustomerPendingHistoryComponent,
    VendorInfoComponent,
    VendorLoginComponent,
    VendorOrderHistoryComponent,
    VendorPendingHistoryComponent,
    PlaceOrderComponent,
    WalletComponent,
    CustomerCancelOrderComponent,
    CMSMainComponent,
    VendorAcceptAndRejectComponent,
    VendorDashboardComponent,
    VendorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
