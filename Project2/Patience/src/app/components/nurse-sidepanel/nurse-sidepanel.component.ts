import { Component, OnInit } from '@angular/core';
import { Nurse } from '../../objects/nurse';
import { NurseService } from '../../services/nurse/nurse.service';
import { Patient } from '../../objects/patient';

@Component({
  selector: 'app-nurse-sidepanel',
  templateUrl: './nurse-sidepanel.component.html',
  styleUrls: ['./nurse-sidepanel.component.css']
})
export class NurseSidepanelComponent implements OnInit {
  patientsNurses: Nurse[];

  constructor(private ns: NurseService) {}

  ngOnInit() {
    this.getAllNurses();
  }

  getAllNurses() {
    this.ns.getNurses().subscribe(
      data => {
        this.randomizeNurses(data);
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

  randomizeNurses(nurses: Nurse[]) {
    let i = 0;
    let random = 0;
    // shuffle the nurses
    for (i = 0; i < nurses.length; i++) {
      random = Math.ceil(Math.random() * nurses.length - 1);
      const temp = nurses[i];
      nurses[i] = nurses[random];
      nurses[random] = temp;
    }
    // take first 5
    if (nurses.length <= 5) {
      this.patientsNurses = nurses;
    } else {
      for (i = 0; i < 5; ++i) {
        this.patientsNurses.push(nurses[i]);
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
