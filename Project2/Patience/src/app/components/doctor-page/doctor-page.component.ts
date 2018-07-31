import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';

import { PATIENTS } from '../../mock-patients';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  patients = PATIENTS;

  constructor() { }

  ngOnInit() {
  }

}
