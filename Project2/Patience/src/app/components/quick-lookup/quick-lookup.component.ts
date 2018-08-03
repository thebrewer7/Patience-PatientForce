import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../services/patient/patient.service';

@Component({
  selector: 'app-quick-lookup',
  templateUrl: './quick-lookup.component.html',
  styleUrls: ['./quick-lookup.component.css']
})
export class QuickLookupComponent implements OnInit {

  username = '';

  constructor(private patientService: PatientService) { }

  ngOnInit() {
  }

  lookup() {
    // search for the patient
    console.log('QuickLookupComponent: search()');
    this.patientService.search(this.username).subscribe(
      PASS => { console.log(PASS); },
      FAIL => { console.log(FAIL); }
    );
  }
}
