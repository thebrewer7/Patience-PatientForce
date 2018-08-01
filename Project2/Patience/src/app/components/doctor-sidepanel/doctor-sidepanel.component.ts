import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../objects/doctor';

import { DOCTORS } from '../../mock-doctors';

@Component({
  selector: 'app-doctor-sidepanel',
  templateUrl: './doctor-sidepanel.component.html',
  styleUrls: ['./doctor-sidepanel.component.css']
})
export class DoctorSidepanelComponent implements OnInit {
  // mock data to simulate pulling from backend
  doctors = DOCTORS;
  newDoctors = [];

  constructor() { }

  ngOnInit() {
    this.randomizeDoctors(this.doctors);
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
