import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';
import { ActivatedRoute } from '@angular/router';
import { DoctoreditinfoService } from '../../services/doctoreditinfo/doctoreditinfo.service';

import { PATIENTS } from '../../mock-patients';

@Component({
  selector: 'app-nurse-doctor-edit-info',
  templateUrl: './nurse-doctor-edit-info.component.html',
  styleUrls: ['./nurse-doctor-edit-info.component.css']
})
export class NurseDoctorEditInfoComponent implements OnInit {

  patientid: number;
  patientnamenew: string;
  patientlocationnew: string;
  patientstatusnew: string;

  patients = PATIENTS;

  constructor(private route: ActivatedRoute, private deis: DoctoreditinfoService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.patientid = parseInt(params.get('patientid'));
    });
    
  }

  public editPatientInfo(patientid)
  {
    

    this.deis.editPatient(patientid).subscribe(
      data => {
        for ( var p in this.patients )
        {
          if ( this.patients[p]['id'] == this.patientid)
          {
            console.log("inside if");
            this.patients[p]['location'] = this.patientlocationnew;
            this.patients[p]['status'] = this.patientstatusnew;
          }
         }

        console.log("DATA: " + JSON.stringify(data));
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }
 

}
