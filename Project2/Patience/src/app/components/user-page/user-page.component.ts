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
    
      var activeuserid = 1;
      switch(activeuserid){
        case 1:
          for ( var i = 0; i < this.users.length; i++ )
          {
            if ( this.users[i]['id'] == 1 )
            {
              for ( var j = 0; j < this.users[i]['patients'].length; j++ )
              {
                this.patientsUsers[j] = this.users[i]['patients'][j];
              }
            }
          }
          break;
        case 2:
          for ( var i = 0; i < this.users.length; i++ )
          {
            if ( this.users[i]['id'] == 2 )
            {
              for ( var j = 0; j < this.users[i]['patients'].length; j++ )
              {
                this.patientsUsers[j] = this.users[i]['patients'][j];
              }
            }
          }
          break;
        case 3:
          for ( var i = 0; i < this.users.length; i++ )
          {
            if ( this.users[i]['id'] == 3 )
            {
              for ( var j = 0; j < this.users[i]['patients'].length; j++ )
              {
                this.patients[j] = this.users[i]['patients'][j];
              }
            }
          }
          break;
        case 4:
          for ( var i = 0; i < this.users.length; i++ )
          {
            if ( this.users[i]['id'] == 4 )
            {
              for ( var j = 0; j < this.users[i]['patients'].length; j++ )
              {
                this.patientsUsers[j] = this.users[i]['patients'][j];
              }
            }
          }
          break;
        case 5:
          for ( var i = 0; i < this.users.length; i++ )
          {
            if ( this.users[i]['id'] == 5 )
            {
              for ( var j = 0; j < this.users[i]['patients'].length; j++ )
              {
                this.patientsUsers[j] = this.users[i]['patients'][j];
              }
            }
          }
          break;
      }
      
  }

  public fetchUserPatientsByUserName(patientid) {

    this.us.getPatients(patientid).subscribe(
      data => {
        for ( var p in this.patients )
        {
          console.log("patientname: " + patientid);
          console.log("patient[p][id]: " + this.patients[p]['id']);
          if ( this.patients[p]['id'] == patientid)
          {
            console.log("inside if");
            this.patientsUsers[p]['location'] = data['location'];
            this.patientsUsers[p]['status'] = data['status'];
          }
         }

        console.log("DATA: " + JSON.stringify(data));
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
