import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../objects/doctor';

@Component({
  selector: 'app-profile-details',
  templateUrl: './profile-details.component.html',
  styleUrls: ['./profile-details.component.css']
})
export class ProfileDetailsComponent implements OnInit {
  // mock data to simulate pulling from backend
  data = {id: 1, name: 'Logan', role: 'Doctor', certifications: ['sdf', 'sdf'], degrees: ['qwe', 'zcc'], experience: 'das', rating: 5, reviews: [], department: 'sad', patients: []};

  constructor() { }

  ngOnInit() {
  }

}
