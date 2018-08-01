import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../objects/doctor';

import { DOCTORS } from '../../mock-doctors';
import { PATIENTS } from '../../mock-patients';

@Component({
  selector: 'app-doctor-sidepanel',
  templateUrl: './doctor-sidepanel.component.html',
  styleUrls: ['./doctor-sidepanel.component.css']
})
export class DoctorSidepanelComponent implements OnInit {
  // mock data to simulate pulling from backend
  doctors = DOCTORS;
  patients = PATIENTS;
  newDoctors = [];
  patientsDoctors = [];
  patientsNurses = [];

  constructor() { }

  ngOnInit() {
    var activeuserid = 3;
    switch(activeuserid){
      case 1:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 1 )
          {
            for ( var j = 0; j < this.patients[i]['doctors'].length; j++ )
            {
              this.patientsDoctors[j] = this.patients[i]['doctors'][j];
            }
          }
        }
        break;
      case 2:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 2 )
          {
            for ( var j = 0; j < this.patients[i]['doctors'].length; j++ )
            {
              this.patientsDoctors[j] = this.patients[i]['doctors'][j];
            }
          }
        }
        break;
      case 3:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 3 )
          {
            for ( var j = 0; j < this.patients[i]['doctors'].length; j++ )
            {
              this.patientsDoctors[j] = this.patients[i]['doctors'][j];
            }
          }
        }
        break;
      case 4:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 4 )
          {
            for ( var j = 0; j < this.patients[i]['doctors'].length; j++ )
            {
              this.patientsDoctors[j] = this.patients[i]['doctors'][j];
            }
          }
        }
        break;
      case 5:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 5 )
          {
            for ( var j = 0; j < this.patients[i]['doctors'].length; j++ )
            {
              this.patientsDoctors[j] = this.patients[i]['doctors'][j];
            }
          }
        }
        break;
      case 6:
        this.randomizeDoctors(this.doctors);
        this.patientsDoctors = [];
        this.patientsDoctors = this.newDoctors;
        break;
    }

  }

  randomizeDoctors(doctors: Doctor[])
  {
    var i = 0;
    var random = 0;
    var randomList = [];
    for (i = 0; i < 5; i++)
    {
      random = Math.ceil(Math.random() * 10 - 1);
      if ( !randomList.includes(random) )
      {
        randomList[i] = random;
        this.newDoctors[i] = doctors[random];
      }
      else
      {
        while ( randomList.includes(random) )
        {
          random = Math.ceil(Math.random() * 10 - 1);
        }
        randomList[i] = random;
        this.newDoctors[i] = doctors[random];
      }
    }
  }

  ratingToStars(rating: number) {
    let stars = '';
    for (let i = 0; i < 5; ++i) {
      if (i < rating) {
        stars = stars + '\u2605';
      } else {
        stars = stars + '\u2606';
      }
    }
    return stars;
  }
}
