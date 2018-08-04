import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';
import { DoctorService } from '../../services/doctor/doctor.service';
import { Patient } from '../../objects/patient';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  doctorsPatients: Patient[];

  constructor(private ds: DoctorService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') === '' ) {
      this.router.navigate(['/login']);
    } else if ( localStorage.getItem('role') !== 'doctor' ) {
      const redirect = localStorage.getItem('role');
      this.router.navigate(['/' + redirect + 'page']);
    }
    this.getAllDoctorsPatients();

  }

  getAllDoctorsPatients() {
    this.ds.getPatients().subscribe(
      data => {
        //console.log(data);
        this.doctorsPatients = data;
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
