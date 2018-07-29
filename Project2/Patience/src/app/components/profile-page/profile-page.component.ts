import { Component, OnInit } from '@angular/core';
import {Review } from '../../objects/review';
@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  reviews: Review[] = [{id: 1, rating: 3, comment: 'dsfsdfsdf fdsdfsdf'}];

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
