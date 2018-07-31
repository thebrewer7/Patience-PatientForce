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
    {id: 1, name: 'Logan', role: 'normal patient', location: '1234', status: 'healthy', condition: 'condition', preferredDoctor: 'Thomas', users: [], nurses: [], doctors: []}
  ]

  constructor(private us: UserService) { }

  ngOnInit() {
  }

  public fetchUserPatientsByUserName(patientname, patientstatus, patientlocation) {
    let patientNameElement = document.getElementById("patientname");
    let patientStatusElement = document.getElementById("patientstatus");
    let patientLocationElement = document.getElementById("patientlocation");

    this.us.getPatients(patientname, patientstatus, patientlocation).subscribe(
      data => {
        // patients.id = data['id'];
        // patient.name = data['name'];
        // patient.role = data['role'];
        // patient.location = data['location'];
        // patient.status = data['status'];
        // patient.condition = data['condition'];
        // patient.preferredDoctor = data['preferredDoctorName'];
        // patient.users = data['users'];
        // patient.nurses = data['nurses'];
        // patient.doctors = data['doctors'];

        console.log("DATA: " + JSON.stringify(data));

        patientNameElement.innerHTML = data['name'];
        patientLocationElement.innerHTML = data['location'];
        patientStatusElement.innerHTML = data['status'];
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
