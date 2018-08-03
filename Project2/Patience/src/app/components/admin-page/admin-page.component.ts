import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';


import { AdminserviceService } from '../../services/adminservice/adminservice.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {


  allaccounts = [];

  constructor(private as: AdminserviceService) { }

  ngOnInit() {
    this.getAllAccounts();
  }

  getAllAccounts()
  {
    //console.log("IN GETALLACCOUNTS");
    this.as.getAllAdminAccounts().subscribe(
      data => {
        //console.log("DATA: " + JSON.stringify(data));
        for ( var d in data )
        {
          this.allaccounts[d] = data[d];
          //console.log(data[d]);
        }
        //console.log("AMOUNTOFACCOUNTS: " + d);
        //console.log("allaccouts after");
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }
}
