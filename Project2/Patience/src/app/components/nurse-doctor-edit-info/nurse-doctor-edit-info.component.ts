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
    this.route.paramMap.subscribe(params => {
      this.patientid = parseInt(params.get('patientid'));
    });
    console.log("patientid: " + this.patientid);
  }

  public editPatientInfo()
  {

    console.log("patientid in editPatientInfo: " + this.patientid);
    console.log("patientlocation in editPatientInfo: "  + this.patientlocation);
    console.log("patientstatus in editPatientInfo: " + this.patientstatus);

    this.deis.editPatient(this.patientid,this.patientlocation,this.patientstatus).subscribe(
      data => {
        console.log("=====================data received==================");
        console.log(data);
        console.log("==============================================")
        this.router.navigate(['/doctorpage']);
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
