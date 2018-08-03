import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs/operators';
import { Review } from '../../objects/review';
import { Details } from '../../objects/details';
import { ConnectorService } from '../../services/connector/connector.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  userpassid: number;

  public data: Details;

  sortedReviewsByDate: Review[];

  reviews: Review[];

  constructor(private conn: ConnectorService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.userpassid = parseInt(params.get('userpassid'), 10);
    });
  }

  receiveData($event) {
    this.data = $event;
    this.fetchReviews();
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

  fetchReviews() {
    this.conn.getReviewByName(this.data.id, this.data.role).subscribe(
        data => {
          console.log(data);
          this.reviews = data;
          this.sortedReviewsByDate = this.reviews.map(x => Object.assign({}, x));
          this.sortedReviewsByDate.sort((a, b) => {
            if (a.datePosted < b.datePosted) return -1;
            else if (a.datePosted > b.datePosted) return 1;
            else return 0;
          });
          console.log(this.sortedReviewsByDate);
        },
        error => {
          console.log("ERROR", error);
        }
    );
  }

}
