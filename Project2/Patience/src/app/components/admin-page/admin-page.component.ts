import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

import { PATIENTS } from '../../mock-patients';
import { DOCTORS } from '../../mock-doctors';
import { NURSES } from '../../mock-nurses';
import { USERS } from '../../mock-users';

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

  constructor() { }

  ngOnInit() {
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
}
