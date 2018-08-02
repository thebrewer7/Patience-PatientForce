import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';

import { DOCTORS } from '../../mock-doctors';
import { PATIENTS } from '../../mock-patients';
import { DoctorService } from '../../services/doctor/doctor.service';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  doctors = DOCTORS;
  patients = PATIENTS;
  doctorsPatients = []

  constructor(private ds: DoctorService) { }

  ngOnInit() {

    this.getAllDoctorsPatients();

  }

  getAllDoctorsPatients()
  {
    this.ds.getPatients().subscribe(
      data => {
        console.log(data);
        for ( var d in data )
        {
          this.doctorsPatients[d] = data[d];
        }
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
