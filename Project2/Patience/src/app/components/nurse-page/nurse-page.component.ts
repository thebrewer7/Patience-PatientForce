import { Component, OnInit } from '@angular/core';
import { NurseService } from '../../services/nurse/nurse.service';

@Component({
  selector: 'app-nurse-page',
  templateUrl: './nurse-page.component.html',
  styleUrls: ['./nurse-page.component.css']
})
export class NursePageComponent implements OnInit {

  nursesDoctors = [];

  constructor(private ns: NurseService) { }

  ngOnInit() {
    
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
