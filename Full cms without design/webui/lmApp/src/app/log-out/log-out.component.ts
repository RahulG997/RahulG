import { Component, OnInit } from '@angular/core';
import { Observable} from 'rxjs';
import 'rxjs/add/observable/of';
import {Router} from '@angular/router';

@Component({
  selector: 'app-log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit {
 
  router: any;

  logout()  {
    this.router.navigate(["/cms-main"]);
  }

  ngOnInit() {
  }

}