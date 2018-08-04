import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';
import { LoginService } from '../../services/login/login.service';
import { tap } from 'rxjs/operators';
import { Router } from '../../../../node_modules/@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private conn: ConnectorService, private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  public fetchSearchUserById(name) {
    console.log(name.control.value);
    this.conn.getSearchUserById(name.control.value).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

  logout() {
    console.log('NavbarComponent: logout()');
    localStorage.removeItem('userid');
    localStorage.removeItem('role');

    this.loginService.logout().subscribe (
      PASS => {
        console.log(PASS);
        this.router.navigate(['/login']);
      },
      FAIL => { console.log(FAIL); }
    );
  }
}
