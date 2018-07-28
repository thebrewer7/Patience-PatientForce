import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../objects/doctor';

@Component({
  selector: 'app-doctor-sidepanel',
  templateUrl: './doctor-sidepanel.component.html',
  styleUrls: ['./doctor-sidepanel.component.css']
})
export class DoctorSidepanelComponent implements OnInit {
  // mock data to simulate pulling from backend
  doctors: Doctor[] = [
    {id: 1, name: 'Logan', role: '', certifications: [], degrees: [], experience: '', rating: 5, reviews: [], department: '', patients: []},
    {id: 2, name: 'Ray', role: '', certifications: [], degrees: [], experience: '', rating: 4, reviews: [], department: '', patients: []},
    {id: 3, name: 'Austin', role: '', certifications: [], degrees: [], experience: '', rating: 3, reviews: [], department: '', patients: []},
    {id: 4, name: 'Andrew', role: '', certifications: [], degrees: [], experience: '', rating: 2, reviews: [], department: '', patients: []},
    {id: 5, name: 'Bobbert', role: '', certifications: [], degrees: [], experience: '', rating: 1, reviews: [], department: '', patients: []}
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
