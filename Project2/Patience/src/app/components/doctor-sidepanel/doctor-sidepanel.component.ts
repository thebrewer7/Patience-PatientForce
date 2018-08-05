import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../objects/doctor';
import { DoctorService } from '../../services/doctor/doctor.service';

@Component({
  selector: 'app-doctor-sidepanel',
  templateUrl: './doctor-sidepanel.component.html',
  styleUrls: ['./doctor-sidepanel.component.css']
})
export class DoctorSidepanelComponent implements OnInit {
  patientsDoctors: Doctor[];

  constructor(private ds: DoctorService) { }

  ngOnInit() {
    if (localStorage.getItem('role') !== '') {
      this.getAllDoctors();
    }
  }

  getAllDoctors() {
    this.ds.getDoctors().subscribe(
      data => {
        this.randomizeDoctors(data);
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

  randomizeDoctors(doctors: Doctor[]) {
    let i = 0;
    let random = 0;
     if (doctors == null) {
      return;
    }

    // shuffle the doctors
    for (i = 0; i < doctors.length; i++) {
      random = Math.ceil(Math.random() * doctors.length - 1);
      const temp = doctors[i];
      doctors[i] = doctors[random];
      doctors[random] = temp;
    }
    // take first 5
    if (doctors.length <= 5) {
      this.patientsDoctors = doctors;
    } else {
      for (i = 0; i < 5; ++i) {
        this.patientsDoctors.push(doctors[i]);
      }
    }
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
