import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

import { PATIENTS } from '../../mock-patients';
import { DOCTORS } from '../../mock-doctors';
import { NURSES } from '../../mock-nurses';
import { USERS } from '../../mock-users';
import { AdminserviceService } from '../../services/adminservice/adminservice.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  patients = PATIENTS;
  doctors = DOCTORS;
  nurses = NURSES;
  users = USERS;
  allaccounts = [];

  constructor(private as: AdminserviceService) { }

  ngOnInit() {
    this.getAllAccounts();
  }

  lockUnlockAccounts()
  {
    if ( this.patients[0]['locked'] == true )
    {
      this.patients[0]['locked'] = false;
    }
    else
    {
      this.patients[0]['locked'] = true;
    }
  }

  getAllAccounts()
  {
    console.log("IN GETALLACCOUNTS");
    this.as.getAllAdminAccounts().subscribe(
      data => {
        console.log("DATA: " + JSON.stringify(data));
        for ( var i = 0; i < JSON.stringify(data).length; i++ )
        {
          this.allaccounts[i] = data[i];
        }
        console.log("allaccouts after");
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }
}
