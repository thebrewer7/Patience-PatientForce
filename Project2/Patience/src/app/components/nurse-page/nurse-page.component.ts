import { Component, OnInit } from '@angular/core';

import { NURSES } from '../../mock-nurses';
import { DOCTORS } from '../../mock-doctors'; 

@Component({
  selector: 'app-nurse-page',
  templateUrl: './nurse-page.component.html',
  styleUrls: ['./nurse-page.component.css']
})
export class NursePageComponent implements OnInit {

  nurses = NURSES;
  doctor = DOCTORS;
  nursesDoctors = [];

  constructor() { }

  ngOnInit() {
    var activeuserid = 1;
      switch(activeuserid){
        case 1:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 1 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 2:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 2 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 3:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 3 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 4:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 4 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 5:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 5 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 6:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 6 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 7:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 7 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 8:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 8 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 9:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 9 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
        case 10:
          for ( var i = 0; i < this.nurses.length; i++ )
          {
            if ( this.nurses[i]['id'] == 10 )
            {
              for ( var j = 0; j < this.nurses[i]['doctors'].length; j++ )
              {
                this.nursesDoctors[j] = this.nurses[i]['doctors'][j];
              }
            }
          }
          break;
      }
  }

}
