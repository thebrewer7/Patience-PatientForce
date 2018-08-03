import { Component, OnInit } from '@angular/core';
import { Nurse } from '../../objects/nurse';
import { NurseService } from '../../services/nurse/nurse.service';

@Component({
  selector: 'app-nurse-sidepanel',
  templateUrl: './nurse-sidepanel.component.html',
  styleUrls: ['./nurse-sidepanel.component.css']
})
export class NurseSidepanelComponent implements OnInit {
  // mock data to simulate pulling from backend

  newNurses = [];
  patientsNurses = [];
  
  constructor(private ns: NurseService) { }

  ngOnInit() {
    this.getAllNurses();
  }

  getAllNurses()
  {
    this.ns.getNurses().subscribe(
      data => {
        console.log(data);
        for ( var d in data )
        {
          this.patientsNurses[d] = data[d];
          //console.log(data[d]);
        }
      },
      error => {
        console.log('ERROR', error);
      }
    );
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
}

