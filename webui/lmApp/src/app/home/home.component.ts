import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../menu.service';
import { Menu } from '../menu';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[MenuServiceService]
 
})
export class HomeComponent implements OnInit {
  errorMsg : any;
  username: string;
  menus: Menu[];
 
  constructor(private menuServ : MenuServiceService) { }

  ngOnInit() {
    this.menuServ.getMenu()
    .subscribe(
      data => this.menus = data,
      error => this.errorMsg = error
    );

  }
}
