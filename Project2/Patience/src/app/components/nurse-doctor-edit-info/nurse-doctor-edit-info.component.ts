import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DoctoreditinfoService } from '../../services/doctoreditinfo/doctoreditinfo.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-nurse-doctor-edit-info',
  templateUrl: './nurse-doctor-edit-info.component.html',
  styleUrls: ['./nurse-doctor-edit-info.component.css']
})
export class NurseDoctorEditInfoComponent implements OnInit {

  patientlocation: string;
  patientstatus: string;
  patientid: number;

  constructor(private route: ActivatedRoute, private deis: DoctoreditinfoService, private router: Router) { }

  doctorsPatients = [];

  ngOnInit() {
    if ( localStorage.getItem('role') === '' ) {
      this.router.navigate(['/login']);
    } else if ( localStorage.getItem('role') !== 'doctor' && localStorage.getItem('role') !== 'nurse' ) {
      const redirect = localStorage.getItem('role');
      this.router.navigate(['/' + redirect + 'page']);
    }

    this.route.paramMap.subscribe(params => {
      this.patientid = parseInt(params.get('patientid'));
    });
  }

  public editPatientInfo()
  {

    this.deis.editPatient(this.patientid,this.patientlocation,this.patientstatus).subscribe(
      data => {
        this.router.navigate(['/doctorpage']);
      }
    );
  }

}
