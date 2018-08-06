import { Component, OnInit } from '@angular/core';
import { Review } from '../../objects/review';
import { Details } from '../../objects/details';
import { ActivatedRoute } from '@angular/router';
import { ProfileDetailsService } from '../../services/profiledetails/profiledetails.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  username: string;

  public data: Details;
  details: Details;

  sortedReviewsByDate: Review[];

  reviews: Review[];

  constructor(private route: ActivatedRoute, private profileDetailsService: ProfileDetailsService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.getDetails();
    });
  }

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

  getDetails() {
    this.profileDetailsService.getDetails(this.username).subscribe (
      DATA => {
        this.details = DATA;
        this.reviews = this.details.reviews;
      }
    );
  }

}
