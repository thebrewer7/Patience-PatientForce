import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../../services/login/login.service';
import { RegistrationService } from '../../services/registration/registration.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '../../../../node_modules/@angular/router';
import { RegistrationValidator } from './register.validator';


declare var $: any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login_username = '';
  login_password = '';
  register_username = '';
  register_password = '';
  password_confirm = '';

  loginFormGroup: FormGroup;
  registrationFormGroup: FormGroup;
  registrationPasswordFormGroup: FormGroup;

  constructor(private loginService: LoginService, private registrationService: RegistrationService, private router: Router, public cookieService: CookieService, private formBuilder: FormBuilder) {
    this.registrationPasswordFormGroup = this.formBuilder.group({
      password: ['', Validators.required],
      passwordconfirm: ['', Validators.required]
    },
    {
      validator: RegistrationValidator.validate.bind(this)
    });

    this.registrationFormGroup = this.formBuilder.group({
      username: ['', Validators.required],
      registrationPasswordFormGroup: this.registrationPasswordFormGroup
    });

    this.loginFormGroup = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

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
    this.loginService.login(this.login_username, this.login_password).subscribe(
      DATA => {
        // this.cookieService.set('data', DATA);
        localStorage.setItem('username', DATA['username']);
        localStorage.setItem('role', DATA['role']);
        console.log(localStorage.getItem('role'));
        console.log(localStorage.getItem('username'));
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
    this.registrationService.register(this.register_username, this.register_password, this.password_confirm).subscribe (
      DATA => {
        console.log(DATA);
        localStorage.setItem('username', DATA['username']);
        localStorage.setItem('role', DATA['role']);
        this.router.navigate(['/userpage']);
      },
      FAIL => { console.log(FAIL); }
    );
  }
}
