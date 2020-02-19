import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { Menu } from '../menu';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[MenuService]
 
})
export class HomeComponent implements OnInit {
  errorMsg : any;
  username: string;
  menus: Menu[];
 
  constructor(private menuServ : MenuService) { }

  ngOnInit() {
    this.menuServ.showMenu()
    .subscribe(
      data => this.menus = data,
      error => this.errorMsg = error
    );

  }
}
