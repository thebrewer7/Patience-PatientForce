import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Review } from '../../objects/review';
import { Details } from '../../objects/details';
import { ConnectorService } from '../../services/connector/connector.service';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { UserDataService } from '../../services/userData/user-data.service';
import { ActivatedRoute } from '@angular/router';
import { ProfileDetailsService } from '../../services/profiledetails/profiledetails.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  username: string;

  public data: Details;
  details: Details; // testing

  sortedReviewsByDate: Review[];

  reviews: Review[];

  constructor(private conn: ConnectorService, private dataServ: UserDataService, private route: ActivatedRoute, private profileDetailsService: ProfileDetailsService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.getDetails();
    });
  }

  // receiveData($event) {
  //   this.data = $event;
  //   this.reviews = this.data.reviews;
  //   if (this.reviews === undefined) {
  //     return;
  //   }
  //   this.sortedReviewsByDate = this.reviews.map(x => Object.assign({}, x));

  //   this.sortedReviewsByDate.sort((a, b) => {
  //     if (a.datePosted < b.datePosted) return -1;
  //     else if (a.datePosted > b.datePosted) return 1;
  //     else return 0;
  //   });
  //   console.log("profile-page reveivedata thie.data:" + this.data);
  //   console.log("profile-page reveivedata thie.reviews:" + this.reviews);
  //   //this.fetchReviews();
  // }

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

  // fetchReviews() {
  //   console.log("fetchReviews this.data.id and this.data.role: " + this.data.id + " and " + this.data.role);
  //   this.conn.getReviewByName(this.data.id, this.data.role).subscribe(
  //       data => {
  //         console.log(data);
  //         this.reviews = data;
  //         this.sortedReviewsByDate = this.reviews.map(x => Object.assign({}, x));
  //         this.sortedReviewsByDate.sort((a, b) => {
  //           if (a.datePosted < b.datePosted) return -1;
  //           else if (a.datePosted > b.datePosted) return 1;
  //           else return 0;
  //         });
  //         console.log(this.sortedReviewsByDate);
  //       },
  //       error => {
  //         console.log("ERROR", error);
  //       }
  //   );
  // }

  getDetails() {
    console.log('ProfileDetailsComponent: getDetails()');
    // send email, username and password to register servlet
    this.profileDetailsService.getDetails(this.username).subscribe (
      DATA => {
        console.log(DATA);
        this.details = DATA;
        this.reviews = this.details.reviews;
      },
      FAIL => { console.log(FAIL); }
    );
  }

}
