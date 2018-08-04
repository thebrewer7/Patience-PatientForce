import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-mini-menu',
  templateUrl: './mini-menu.component.html',
  styleUrls: ['./mini-menu.component.css']
})
export class MiniMenuComponent implements OnInit {
  constructor() { conn : ConnectorService }

  ngOnInit() { }

  public fetchSearchFill() {
      conn.getSearchFill().pipe(
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
}
