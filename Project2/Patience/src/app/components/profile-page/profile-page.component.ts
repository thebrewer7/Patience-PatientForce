import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs/operators';
import { Review } from '../../objects/review';
import { Details } from '../../objects/details';
import { ConnectorService } from '../../services/connector/connector.service';
@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  public data: Details;

  sortedReviewsByDate: Review[];

  reviews: Review[] = [
    {
      id: 1,
      date: Date.now(),
      role: "",
      rating: 3,
      review: 'dsfsdfsdf fdsdfsdf dsfsdfsdf fdsdfsdf dsfsdfsdf fdsdfsdf '
    },
    {
      id: 2,
      date: Date.now(),
      role: "",
      rating: 4,
      review: 'dsfsdfsdf fdsdfsdf'
    }
  ];

  constructor(private conn: ConnectorService) {}

  ngOnInit() {
  }

  receiveData($event){
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

  fetchReviews(){
    this.conn.getReviewByName(this.data.name).subscribe(
        data => {
          this.reviews = data;
          this.sortedReviewsByDate = this.reviews.map(x => Object.assign({}, x));
          this.sortedReviewsByDate.sort((a, b) => {
            if (a.date < b.date) return -1;
            else if (a.date > b.date) return 1;
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
