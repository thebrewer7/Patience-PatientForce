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
  userpassid: number;

  public data: Details;
  @Output() dataEvent = new EventEmitter<Details>();

  constructor(private userData: UserDataService, private profileDetailsService: ProfileDetailsService, private route: ActivatedRoute) {
    this.userData.changeData(this.data);
  }

  sendData() {
    this.dataEvent.emit(this.data);
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.userpassid = parseInt(params.get('userpassid'));
    });
    this.getDetails();
    this.userData.currentData.subscribe(data => this.data = data);
    this.sendData();
  }

  getDetails() {
    console.log('ProfileDetailsComponent: getDetails()');
    // send email, username and password to register servlet
    this.profileDetailsService.getDetails(this.userpassid).subscribe (
      DATA => {
        console.log(DATA);
        this.data = DATA;
      },
      FAIL => { console.log(FAIL); }
    );
  }
}
