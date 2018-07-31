import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  patients: Patient[] = [
    {id: 1, name: 'Logan', role: 'normal patient', location: '1234', status: 'in ER', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 2, name: 'Andrew', role: 'normal patient', location: '1235', status: 'outside', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 3, name: 'Ray', role: 'normal patient', location: '1236', status: 'going to ER', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 4, name: 'Austin', role: 'normal patient', location: '1237', status: 'normal room', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 5, name: 'Bobbert', role: 'normal patient', location: '1238', status: 'out', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []}
  ]

  constructor() { }

  ngOnInit() {
  }

}
