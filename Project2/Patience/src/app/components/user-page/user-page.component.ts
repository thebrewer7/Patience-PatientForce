import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { Patient } from '../../objects/patient';

import { PATIENTS } from '../../mock-patients';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  patients = PATIENTS;

  constructor(private us: UserService) { }

  ngOnInit() {
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
            this.patients[p]['location'] = data['location'];
            this.patients[p]['status'] = data['status'];
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
