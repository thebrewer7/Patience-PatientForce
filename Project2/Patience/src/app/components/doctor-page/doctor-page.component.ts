import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';

import { DOCTORS } from '../../mock-doctors';
import { PATIENTS } from '../../mock-patients';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  doctors = DOCTORS;
  patients = PATIENTS;
  doctorsPatients = []

  constructor() { }

  ngOnInit() {
    var activeuserid = 1;
      switch(activeuserid){
        case 1:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 1 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 2:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 2 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 3:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 3 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 4:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 4 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 5:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 5 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 6:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 6 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.patients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 7:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 7 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 8:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 8 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 9:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 9 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
        case 10:
          for ( var i = 0; i < this.doctors.length; i++ )
          {
            if ( this.doctors[i]['id'] == 10 )
            {
              for ( var j = 0; j < this.doctors[i]['patients'].length; j++ )
              {
                this.doctorsPatients[j] = this.doctors[i]['patients'][j];
              }
            }
          }
          break;
      }
  }

}
