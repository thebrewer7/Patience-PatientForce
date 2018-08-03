import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { Patient } from '../../objects/patient';

import { PATIENTS } from '../../mock-patients';
import { USERS } from '../../mock-users';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  patients = PATIENTS;
  users = USERS;
  patientsUsers = [];

  constructor(private us: UserService) { }

  ngOnInit() {
    console.log(localStorage.getItem('userpassid'));
    console.log(localStorage.getItem('role'));
  }

  public fetchUserPatientsByUserName(patientid) {

    this.us.getPatients(patientid).subscribe(
      data => {
        for ( var d in data )
        {
          //console.log("patientname: " + patientid);
          //console.log("patient[p][id]: " + this.patients[p]['id']);
          // if ( this.patients[p]['id'] == patientid)
          // {
          //   console.log("inside if");
          //   this.patientsUsers[p]['location'] = data['location'];
          //   this.patientsUsers[p]['status'] = data['status'];
          // }
          this.patientsUsers[d] = data[d];
         }
         console.log("DATA:");
         console.log(JSON.stringify(data));
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
