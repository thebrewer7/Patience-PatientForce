import { Component, OnInit } from '@angular/core';
import { HistoryService } from '../../services/history/history.service';
import { Router } from '../../../../node_modules/@angular/router';
import { History } from '../../objects/history';
@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  allHistories: History;
  username: string;

  constructor(private hs: HistoryService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') === '' ) {
      this.router.navigate(['/login']);
    } else if ( localStorage.getItem('role') !== 'patient' ) {
      const redirect = localStorage.getItem('role');
      this.router.navigate(['/' + redirect + 'page']);
    } else {
      this.allHistories = new History();
      this.getHistory();
    }
  }

  getHistory() {
    this.username = localStorage.getItem('username');
    console.log("===================patientpage getHistory()===============")
    console.log("username: " + this.username);

    this.hs.getHistory(this.username).subscribe(
      data => {
        console.log("===================data inside patientpage getHistory()================");
        console.log(data);
        console.log("==================================================");
        console.log("===================datainside allHistories==================");
        this.allHistories = data;
        // for ( var d in data )
        // {
        //   this.allHistories[d]['age'] = data[d]['age'];
        //   this.allHistories[d]['weight'] = data[d]['weight'];
        //   this.allHistories[d]['height'] = data[d]['height'];
        //   this.allHistories[d]['bloodPressureCondition'] = data[d]['bloodPressureCondition'];
        // }

        console.log(this.allHistories);
        console.log("=======================================================");
      },
      error => {
        console.log('ERROR', error);
      }
  );
  }

}
