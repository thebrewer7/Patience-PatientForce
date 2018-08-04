import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs/operators';
import { Review } from '../../objects/review';
import { Details } from '../../objects/details';
import { ConnectorService } from '../../services/connector/connector.service';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { UserDataService } from '../../services/userData/user-data.service';

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
      name: "Logan",
      datePosted: Date.now().toLocaleString(),
      rating: 3,
      review: 'dsfsdfsdf fdsdfsdf dsfsdfsdf fdsdfsdf dsfsdfsdf fdsdfsdf '
    },
    {
      id: 2,
      name: "Logan",
      datePosted: Date.now().toLocaleString(),
      rating: 4,
      review: 'dsfsdfsdf fdsdfsdf'
    }
  ];

  constructor(private conn: ConnectorService, private dataServ: UserDataService) {}

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
