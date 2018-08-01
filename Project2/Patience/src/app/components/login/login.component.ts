import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoginService } from '../../services/login/login.service';
import { RegistrationService } from '../../services/registration/registration.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '../../../../node_modules/@angular/router';

declare var $: any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  email = '';
  password = '';
  passwordconfirm = '';

  constructor(private loginService: LoginService, private registrationService: RegistrationService, private router: Router, public cookieService: CookieService) {}//

  ngOnInit() {
    $(document).ready(function() {
      $('#login-form-link').click(function(e) {
        $('#login-form')
          .delay(100)
          .fadeIn(100);
        $('#register-form').fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
      });
      $('#register-form-link').click(function(e) {
        $('#register-form')
          .delay(100)
          .fadeIn(100);
        $('#login-form').fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
      });
    });
  }

  login() {
    console.log('LoginComponent: login()');
    // send username and password to login servlet
    this.loginService.login(this.username, this.password).subscribe(
      DATA => {
        // this.cookieService.set('data', DATA);
        switch (DATA['role']) {
          case 'admin':
            this.router.navigate(['/adminpage']);
            break;
          case 'doctor':
            this.router.navigate(['/doctorpage']);
            break;
          case 'nurse':
            this.router.navigate(['/nursepage']);
            break;
          case 'patient':
            this.router.navigate(['/patientpage']);
            break;
          case 'user':
            this.router.navigate(['/userpage']);
          break;
          default:
            this.router.navigate(['/login']);
        }
        console.log(DATA);
      },
      ERROR => {
        console.log(ERROR + ' Error: login failed');
      }
    );
  }

  register() {
    console.log('LoginComponent: register()');
    // send email, username and password to register servlet
    this.registrationService.register(this.email, this.username, this.password, this.passwordconfirm).subscribe (
      PASS => { console.log('pass'); },
      FAIL => { console.log('failed'); }
    );
  }
}
