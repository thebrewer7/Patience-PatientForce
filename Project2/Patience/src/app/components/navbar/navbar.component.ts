import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private conn: ConnectorService) {}
  
  ngOnInit() {}

  public fetchSearchFill() {
    this.conn.getSearchFill().pipe(
      tap(
        data => {
          // grab the data
        },
        error => {
          console.log('ERROR', error);
        }
      )
    );
  }
  
  public fetchSearchUserById(name) {
    console.log(name.control.value);
    this.conn.getSearchUserById(name.control.value).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }
}
