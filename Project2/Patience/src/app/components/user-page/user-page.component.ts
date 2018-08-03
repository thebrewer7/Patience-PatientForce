import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  patientsUsers = [];

  constructor(private us: UserService) { }

  ngOnInit() {
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
