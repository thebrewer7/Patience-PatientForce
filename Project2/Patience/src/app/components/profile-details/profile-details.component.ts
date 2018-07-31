import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../objects/doctor';
import { Details } from '../../objects/details';
import { UserDataService } from '../../services/userData/user-data.service';

@Component({
  selector: 'app-profile-details',
  templateUrl: './profile-details.component.html',
  styleUrls: ['./profile-details.component.css']
})
export class ProfileDetailsComponent implements OnInit {
  // mock data to simulate pulling from backend

  public data: Details;


  constructor(private userData: UserDataService) { 
    this.data = {id: 1, name: 'Logan', role: 'Doctor', certifications: ['sdf', 'sdf'], degrees: ['qwe', 'zcc'], experience: 'das', rating: 5, reviews: [], department: 'sad', patients: []};
    this.userData.changeData(this.data);
  }

  ngOnInit() {
    this.userData.currentData.subscribe(data => this.data = data)
  }

}
