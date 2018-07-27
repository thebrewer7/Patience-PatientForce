import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quick-lookup',
  templateUrl: './quick-lookup.component.html',
  styleUrls: ['./quick-lookup.component.css']
})
export class QuickLookupComponent implements OnInit {

  searchText = '';

  constructor() { }

  ngOnInit() {
  }

  lookup() {
    // search for the user
  }
}
