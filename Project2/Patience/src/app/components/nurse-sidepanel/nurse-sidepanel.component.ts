import { Component, OnInit } from '@angular/core';
import { Nurse } from '../../objects/nurse';
import { NurseService } from '../../services/nurse/nurse.service';

import { NURSES } from '../../mock-nurses';
import { PATIENTS } from '../../mock-patients';

@Component({
  selector: 'app-nurse-sidepanel',
  templateUrl: './nurse-sidepanel.component.html',
  styleUrls: ['./nurse-sidepanel.component.css']
})
export class NurseSidepanelComponent implements OnInit {
  // mock data to simulate pulling from backend
  nurses = NURSES;
  patients = PATIENTS;
  newNurses = [];
  patientsNurses = [];
  

  constructor(private ns: NurseService) { }

  ngOnInit() {
    var activeuserid = 6;
    switch(activeuserid){
      case 1:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 1 )
          {
            for ( var j = 0; j < this.patients[i]['nurses'].length; j++ )
            {
              this.patientsNurses[j] = this.patients[i]['nurses'][j];
            }
          }
        }
        break;
      case 2:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 2 )
          {
            for ( var j = 0; j < this.patients[i]['nurses'].length; j++ )
            {
              this.patientsNurses[j] = this.patients[i]['nurses'][j];
            }
          }
        }
        break;
      case 3:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 3 )
          {
            for ( var j = 0; j < this.patients[i]['nurses'].length; j++ )
            {
              this.patientsNurses[j] = this.patients[i]['nurses'][j];
            }
          }
        }
        break;
      case 4:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 4 )
          {
            for ( var j = 0; j < this.patients[i]['nurses'].length; j++ )
            {
              this.patientsNurses[j] = this.patients[i]['nurses'][j];
            }
          }
        }
        break;
      case 5:
        for ( var i = 0; i < this.patients.length; i++ )
        {
          if ( this.patients[i]['id'] == 5 )
          {
            for ( var j = 0; j < this.patients[i]['nurses'].length; j++ )
            {
              this.patientsNurses[j] = this.patients[i]['nurses'][j];
            }
          }
        }
        break;
      case 6:
        this.randomizeNurses(this.nurses);
        this.patientsNurses = [];
        this.patientsNurses = this.newNurses;
        break;
    }
 }

  randomizeNurses(nurses: Nurse[])
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
        this.newNurses[i] = nurses[random];
      }
      else
      {
        while ( randomList.includes(random) )
        {
          random = Math.ceil(Math.random() * 10 - 1);
        }
        randomList[i] = random;
        this.newNurses[i] = nurses[random];
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

  fetchNurses()
  {
    this.ns.getNurses().subscribe(
      data => {
        console.log("DATA: " + data);
      },
      error => {
        console.log('ERROR', error);
      }
    )
  }

}

