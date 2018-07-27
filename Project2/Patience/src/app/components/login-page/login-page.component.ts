import { Component, OnInit } from '@angular/core';

import { LoginComponent } from '../login/login.component';
import { QuickLookupComponent } from '../quick-lookup/quick-lookup.component';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
