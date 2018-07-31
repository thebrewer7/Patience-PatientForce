import { Component, OnInit } from '@angular/core';
import { Review } from '../../objects/review';
@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  reviews: Review[] = [
    {
      id: 1,
      rating: 3,
      comment: 'dsfsdfsdf fdsdfsdf dsfsdfsdf fdsdfsdf dsfsdfsdf fdsdfsdf '
    },
    {
      id: 2,
      rating: 4,
      comment: 'dsfsdfsdf fdsdfsdf'
    }
  ];

  constructor() {}

  ngOnInit() {}

  public ratingToStars(rating: number) {
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
