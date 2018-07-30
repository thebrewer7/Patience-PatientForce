import { Component, OnInit } from '@angular/core';
import { Nurse } from '../../objects/nurse';

@Component({
  selector: 'app-nurse-sidepanel',
  templateUrl: './nurse-sidepanel.component.html',
  styleUrls: ['./nurse-sidepanel.component.css']
})
export class NurseSidepanelComponent implements OnInit {
  // mock data to simulate pulling from backend
  nurses: Nurse[] = [
    {id: 1, name: 'Logan', role: '', certifications: [], rating: 1, reviews: [], department: '', patients: []},
    {id: 2, name: 'Ray', role: '', certifications: [], rating: 2, reviews: [], department: '', patients: []},
    {id: 3, name: 'Austin', role: '', certifications: [], rating: 3, reviews: [], department: '', patients: []},
    {id: 4, name: 'Andrew', role: '', certifications: [], rating: 4, reviews: [], department: '', patients: []},
    {id: 5, name: 'Bobbert', role: '', certifications: [], rating: 5, reviews: [], department: '', patients: []}
  ];

  constructor() { }

  ngOnInit() {
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

