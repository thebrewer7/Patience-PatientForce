import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';
import { LoginComponent } from '../login/login.component';
import { QuickLookupComponent } from '../quick-lookup/quick-lookup.component';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') != '' )
    {
      var redirect = localStorage.getItem('role');
      this.router.navigate(['/'+ redirect + 'page']);
    }
    localStorage.setItem('role', '');
    localStorage.setItem('userpassid', '');
  }

}
