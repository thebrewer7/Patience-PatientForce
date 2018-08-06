import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Doctor } from '../../objects/doctor';
import { Details } from '../../objects/details';
import { UserDataService } from '../../services/userData/user-data.service';
import { ProfileDetailsService } from '../../services/profiledetails/profiledetails.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile-details',
  templateUrl: './profile-details.component.html',
  styleUrls: ['./profile-details.component.css']
})
export class ProfileDetailsComponent implements OnInit {
  username: string;

  public data: Details;
  @Output() dataEvent = new EventEmitter<Details>();

  constructor(private userData: UserDataService, private profileDetailsService: ProfileDetailsService, private route: ActivatedRoute) {
    //this.userData.changeData(this.data);
  }

  sendData() {
    this.dataEvent.emit(this.data);
  }

  recieveData($event){
    this.data = $event;
    console.log(this.data);
  }

  ngOnInit() {
    this.userData.currentData.subscribe(data => this.data = data);
    console.log(this.data);
    this.route.paramMap.subscribe(params => {
      this.username = params.get('username');
    });
    this.getDetails();
    this.sendData();
  }

  getDetails() {
    console.log('ProfileDetailsComponent: getDetails()');
    // send email, username and password to register servlet
    this.profileDetailsService.getDetails(this.username).subscribe (
      DATA => {
        console.log("getDetails() DATA:" + DATA);
        this.data = DATA;
      },
      FAIL => { console.log(FAIL); }
    );
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
