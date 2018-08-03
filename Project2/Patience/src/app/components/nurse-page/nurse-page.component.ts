import { Component, OnInit } from '@angular/core';
import { NurseService } from '../../services/nurse/nurse.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-nurse-page',
  templateUrl: './nurse-page.component.html',
  styleUrls: ['./nurse-page.component.css']
})
export class NursePageComponent implements OnInit {

  nursesDoctors = [];

  constructor(private ns: NurseService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') != 'nurse' )
    {
      var redirect = localStorage.getItem('role');
      this.router.navigate(['/'+ redirect + 'page']);
    }
    this.getAllNursesDoctors();
  }

  getAllNursesDoctors()
  {
    this.ns.getNursesDoctors().subscribe(
      data => {
        console.log(data);
        for ( var d in data )
        {
          this.nursesDoctors[d] = data[d];
          console.log(data[d]);
        }
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
