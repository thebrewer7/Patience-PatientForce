import { Component, OnInit } from '@angular/core';

import { PATIENTS } from '../../mock-patients'; 

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  patients = PATIENTS;
  newpatients = [];

  constructor() { }

  ngOnInit() {
    var activeuserid = 1;
      switch(activeuserid){
        case 1:
          this.newpatients[0] = this.patients[0];
          break;
        case 2:
          this.newpatients[1] = this.patients[1];
          break;
        case 3:
          this.newpatients[3] = this.patients[3];
          break;
        case 4:
          this.newpatients[4] = this.patients[4];
          break;
        case 5:
          this.newpatients[5] = this.patients[5];
          break;
      }
  }

}
