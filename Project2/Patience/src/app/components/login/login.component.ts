import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
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

  constructor() {}

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
    // send username and password to login servlet
  }

  register() {
    // send email, username and password to register servlet
  }
}
