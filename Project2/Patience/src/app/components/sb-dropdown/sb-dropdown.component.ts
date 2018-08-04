import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sb-dropdown',
  templateUrl: './sb-dropdown.component.html',
  styleUrls: ['./sb-dropdown.component.css']
})
export class SbDropdownComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

 toggleDropdown() {
    document.getElementById("myDropdown").classList.toggle("show");
}

filterDropdown() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("searchArea");
    filter = input.value.toUpperCase();
    var div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
  }
}
