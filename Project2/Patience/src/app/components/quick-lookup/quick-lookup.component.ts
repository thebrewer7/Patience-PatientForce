import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../services/patient/patient.service';
import { Patient } from '../../objects/patient';

@Component({
  selector: 'app-quick-lookup',
  templateUrl: './quick-lookup.component.html',
  styleUrls: ['./quick-lookup.component.css']
})
export class QuickLookupComponent implements OnInit {

  username = '';
  patient: Patient;

  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.patient = new Patient();
  }

  lookup() {
    // search for the patient
    console.log('QuickLookupComponent: search()');
    this.patientService.search(this.username).subscribe(
      PASS => { this.patient = PASS;
        console.log(PASS); },
      FAIL => { console.log(FAIL); }
    );
  }
}
