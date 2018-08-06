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

    this.hs.getHistory(this.username).subscribe(
      data => {
        this.allHistories = data;
      }
  );
  }

}
