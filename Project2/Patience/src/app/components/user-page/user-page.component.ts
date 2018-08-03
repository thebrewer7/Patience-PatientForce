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
    if ( localStorage.getItem('role') == 'null' )
    {
      this.router.navigate(['/login']);
    }
    else if ( localStorage.getItem('role') != 'doctor' )
    {
      var redirect = localStorage.getItem('role');
      this.router.navigate(['/'+ redirect + 'page']);
    }
    console.log(localStorage.getItem('userpassid'));
    console.log(localStorage.getItem('role'));
    this.fetchUserPatientsByUserName();
  }

  public fetchUserPatientsByUserName() {

    this.us.getPatients().subscribe(
      data => {
        for ( var d in data )
        {
          this.patientsUsers[d] = data[d];
         }
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
