import { Component, OnInit } from '@angular/core';
import { HistoryService } from '../../services/history/history.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  allHistories = [];

  constructor(private hs: HistoryService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') != 'patient' )
    {
      var redirect = localStorage.getItem('role');
      this.router.navigate(['/'+ redirect + 'page']);
    }
    this.getHistory();
  }

  getHistory()
  {
    this.hs.getHistory().subscribe(
      data => {
        console.log(data);
        for ( var d in data )
        {
          this.allHistories[d] = data[d];
          console.log("HISTORY: " + JSON.stringify(this.allHistories[d]));
        }
        
      },
      error => {
        console.log("ERROR", error);
      }
  );
  }

}
