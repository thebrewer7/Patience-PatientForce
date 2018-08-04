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
  // mock data to simulate pulling from backend

  newNurses = [];
  patientsNurses: Nurse[];

  constructor(private ns: NurseService) {}

  ngOnInit() {
    this.getAllNurses();
  }

  getAllNurses() {
    this.ns.getNurses().subscribe(
      data => {
        console.log(data);
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
    let randomList: Nurse[];
    // shuffle the nurses
    for (i = 0; i < nurses.length; i++) {
      random = Math.ceil(Math.random() * nurses.length - 1);
      const temp = nurses[i];
      nurses[i] = nurses[random];
      nurses[random] = temp;
    }
    // take first 5
    if (nurses.length < 5) {
      return nurses;
    } else {
      for (i = 0; i < 5; ++i) {
        randomList.push(nurses[i]);
      }
      return randomList;
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
