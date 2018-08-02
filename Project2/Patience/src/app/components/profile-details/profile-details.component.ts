import { Component, OnInit, Output, EventEmitter } from '@angular/core';
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
  @Output() dataEvent = new EventEmitter<Details>();

  constructor(private userData: UserDataService) { 
    this.data = {id: 1, name: 'Logan', role: 'Doctor', certifications: ['OCA', 'OCP'], degrees: ['B.S. Health Science'], 
                 experience: '1 year', rating: 5, reviews: [], department: 'West Wing', patients: []};
    this.userData.changeData(this.data);
  }

  sendData() {
    this.dataEvent.emit(this.data);
  }

  ngOnInit() {
    this.userData.currentData.subscribe(data => this.data = data)
    this.sendData();
  }

}