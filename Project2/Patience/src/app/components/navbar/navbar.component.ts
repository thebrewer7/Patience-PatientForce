import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {

  constructor(private conn:ConnectorService) { }

  ngOnInit() {
  }

  public fetchSearchResults(){
    this.conn.getSearchResults().subscribe(
      data => {
       //save data to the dropdown
      },
      error => {
        console.log("ERROR", error);
      }
    );
  }
}
