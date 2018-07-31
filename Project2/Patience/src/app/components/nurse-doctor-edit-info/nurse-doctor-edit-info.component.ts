import { Component, OnInit } from '@angular/core';
import { Patient } from '../../objects/patient';
import { ActivatedRoute } from '@angular/router';
import { DoctoreditinfoService } from '../../services/doctoreditinfo/doctoreditinfo.service';

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

  patients: Patient[] = [
    {id: 1, name: 'Logan', role: 'normal patient', location: '1234', status: 'in ER', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 2, name: 'Andrew', role: 'normal patient', location: '1235', status: 'outside', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 3, name: 'Ray', role: 'normal patient', location: '1236', status: 'going to ER', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 4, name: 'Austin', role: 'normal patient', location: '1237', status: 'normal room', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 5, name: 'Bobbert', role: 'normal patient', location: '1238', status: 'out', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []}
  ]

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
            this.patients[p]['id'] = data['id'];
            this.patients[p]['name'] = this.patientnamenew;
            this.patients[p]['role'] = data['role'];
            this.patients[p]['location'] = this.patientlocationnew;
            this.patients[p]['status'] = this.patientstatusnew;
            this.patients[p]['condition'] = data['condition'];
            this.patients[p]['preferredDoctor'] = data['preferredDoctorName'];
            this.patients[p]['users'] = data['users'];
            this.patients[p]['nurses'] = data['nurses'];
            this.patients[p]['doctors'] = data['doctors'];
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
