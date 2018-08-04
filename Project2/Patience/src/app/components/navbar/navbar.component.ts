import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';
import { LoginService } from '../../services/login/login.service';
import { tap } from 'rxjs/operators';
import { Details } from '../../objects/details';
import { Router } from '../../../../node_modules/@angular/router';
import { UserDataService } from '../../services/userData/user-data.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public data: Details;

  constructor(private conn: ConnectorService, private dateServ: UserDataService, private loginService: LoginService, private router: Router) {}

  ngOnInit() {
    this.dateServ.currentData.subscribe(data => this.data = data);
  }

  public fetchSearchFill() {
    this.conn.getSearchFill().pipe(
      tap(
        data => {
          // grab the data
        },
        error => {
          console.log('ERROR', error);
        }
      )
    );
  }

  public fetchSearchUserById(name) {
    console.log(name.control.value);
    this.conn.getSearchUserById(name.control.value).subscribe(
      data => {
        this.dateServ.changeData(data);
        this.router.navigate(['/profile']);
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
