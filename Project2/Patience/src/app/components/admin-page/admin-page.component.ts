import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { Router } from '../../../../node_modules/@angular/router';


import { AdminserviceService } from '../../services/adminservice/adminservice.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {


  allaccounts = [];

  constructor(private as: AdminserviceService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') === '' ) {
      this.router.navigate(['/login']);
    } else if ( localStorage.getItem('role') !== 'admin' ) {
      const redirect = localStorage.getItem('role');
      this.router.navigate(['/' + redirect + 'page']);
    } else {
      this.getAllAccounts();
    }
  }

  getAllAccounts() {
    this.as.getAllAdminAccounts().subscribe(
      data => {
        for ( var d in data )
        {
          this.allaccounts[d] = data[d];
        }
      }
    );
  }
}
