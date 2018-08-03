import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';
import { ActivatedRoute } from '@angular/router';
import { DoctoreditinfoService } from '../../services/doctoreditinfo/doctoreditinfo.service';
import { Router } from '../../../../node_modules/@angular/router';
import { PATIENTS } from '../../mock-patients';
import { DoctorService } from '../../services/doctor/doctor.service';

@Component({
  selector: 'app-nurse-doctor-edit-info',
  templateUrl: './nurse-doctor-edit-info.component.html',
  styleUrls: ['./nurse-doctor-edit-info.component.css']
})
export class NurseDoctorEditInfoComponent implements OnInit {

  patientid: number;

  constructor(private route: ActivatedRoute, private deis: DoctoreditinfoService, private router: Router) { }

  doctorsPatients = [];

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.patientid = parseInt(params.get('patientid'));
    });
  }

  public editPatientInfo(patientid,patientlocation,patientstatus)
  {
    this.deis.editPatient(patientid,patientlocation,patientstatus).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['/doctorpage']);
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
