import { Component, OnInit } from '@angular/core';
import { NurseService } from '../../services/nurse/nurse.service';
import { Router } from '../../../../node_modules/@angular/router';
import { Doctor } from '../../objects/doctor';

@Component({
  selector: 'app-nurse-page',
  templateUrl: './nurse-page.component.html',
  styleUrls: ['./nurse-page.component.css']
})
export class NursePageComponent implements OnInit {

  nursesDoctors: Doctor[];

  constructor(private ns: NurseService, private router: Router) { }

  ngOnInit() {
    if ( localStorage.getItem('role') === '' ) {
      this.router.navigate(['/login']);
    } else if ( localStorage.getItem('role') !== 'doctor' ) {
      const redirect = localStorage.getItem('role');
      this.router.navigate(['/' + redirect + 'page']);
    }
    this.getAllNursesDoctors();
  }

  getAllNursesDoctors() {
    this.ns.getNursesDoctors().subscribe(
      data => {
        console.log(data);
        this.nursesDoctors = data;
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }

}
