import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';
import { DoctorService } from '../../services/doctor/doctor.service';

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css']
})
export class DoctorPageComponent implements OnInit {

  doctorsPatients = []

  constructor(private ds: DoctorService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') != 'doctor' )
    {
      var redirect = localStorage.getItem('role');
      this.router.navigate(['/'+ redirect + 'page']);
    }
    this.getAllDoctorsPatients();

  }

  getAllDoctorsPatients()
  {
    this.ds.getPatients().subscribe(
      data => {
        //console.log(data);
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
