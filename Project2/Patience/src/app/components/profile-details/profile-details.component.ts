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
    this.data = {id: 50, name: 'Logan', role: 'Doctor', certifications: ['OCA', 'OCP'], degrees: ['B.S. Health Science'], 
                 experience: '1 year', rating: 5, reviews: [], department: 'West Wing', patients: []};
  }

  sendData() {
    this.dataEvent.emit(this.data);
  }

  recieveData($event){
    this.data = $event;
    console.log(this.data);
  }

  ngOnInit() {
    this.userData.currentData.subscribe(data => this.data = data)
    console.log(this.data);
    this.sendData();
  }

}