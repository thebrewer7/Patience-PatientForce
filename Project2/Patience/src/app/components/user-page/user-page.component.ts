import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { Patient } from '../../objects/patient';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  patients: Patient[] = [
    {id: 1, name: 'Logan', role: 'normal patient', location: '1234', status: 'in ER', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 2, name: 'Andrew', role: 'normal patient', location: '1235', status: 'outside', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 3, name: 'Ray', role: 'normal patient', location: '1236', status: 'going to ER', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 4, name: 'Austin', role: 'normal patient', location: '1237', status: 'normal room', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []},
    {id: 5, name: 'Bobbert', role: 'normal patient', location: '1238', status: 'out', condition: 'healthy', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []}
  ]

  constructor(private us: UserService) { }

  ngOnInit() {
  }

  public fetchUserPatientsByUserName(patientname) {

    this.us.getPatients(patientname).subscribe(
      data => {
        for ( var p in this.patients )
        {
          console.log("patientname: " + patientname);
          console.log("patient[p][name]: " + this.patients[p]['name']);
          if ( this.patients[p]['name'] == patientname)
          {
            console.log("inside if");
            this.patients[p]['id'] = data['id'];
            this.patients[p]['name'] = data['name'];
            this.patients[p]['role'] = data['role'];
            this.patients[p]['location'] = data['location'];
            this.patients[p]['status'] = data['status'];
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
