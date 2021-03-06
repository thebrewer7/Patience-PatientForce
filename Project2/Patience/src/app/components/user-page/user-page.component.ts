import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  patientsUsers = [];

  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') === '' ) {
      this.router.navigate(['/login']);
    } else if ( localStorage.getItem('role') !== 'user' ) {
      const redirect = localStorage.getItem('role');
      this.router.navigate(['/' + redirect + 'page']);
    } else {
      this.fetchUserPatientsByUserName();
    }
  }

  public fetchUserPatientsByUserName() {
    const username = localStorage.getItem('username');

    this.us.getPatients(username).subscribe(
      data => {
        this.patientsUsers = data;
      }
    );
  }

}
