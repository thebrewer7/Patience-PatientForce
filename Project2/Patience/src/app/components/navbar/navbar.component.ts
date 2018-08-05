import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';
import { LoginService } from '../../services/login/login.service';
import { tap } from 'rxjs/operators';
import { Details } from '../../objects/details';
import { Router } from '../../../../node_modules/@angular/router';
import { UserDataService } from '../../services/userData/user-data.service';
import { SearchDetails } from '../../objects/searchDetails';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public data: Details;
  public searchData: Details[];
  dropdownDisabled: boolean = true;

  constructor(private conn: ConnectorService, private dataServ: UserDataService, private loginService: LoginService, private router: Router) {

  }

  ngOnInit() {
    this.dataServ.currentData.subscribe(data => this.data = data);
    this.fetchSearchFill();
  }

  getUsername()
  {
    return localStorage.getItem('username');
  }

  checkIfLoggedIn()
  {
    console.log("getusername: " + this.getUsername());
    if ( this.getUsername() == '' || this.getUsername() == null )
    {
      this.dropdownDisabled = true;
      return;
    }
    this.dropdownDisabled = false;
  }

  public fetchSearchFill() {
    // this.searchData = [{id:50, name:"logan", role:"doctor", certifications:[], degrees:[], experience:"sdjflksdjf slfjdslfj", rating:3, reviews:[{id:1, name:"logan", datePosted:"03-AUG-18 12.00.00 AM", rating:3, review:"sjfldjfs sljfdljfs"}], department:"The Department", patients:[]},
    //                   {id:51, name:"andrew", role:"doctor", certifications:[], degrees:[], experience:"sdjflksdjf slfjdslfj", rating:3, reviews:[{id:2, name:"logan", datePosted:"02-AUG-18 12.00.00 AM", rating:2, review:"sjfldjfs sljfdljfs"}], department:"The Department", patients:[]}];
    this.conn.getSearchFill().subscribe(
        data => {
          this.searchData = data;
          console.log(this.searchData);
        },
        error => {
          console.log('ERROR', error);
        }
      );
  }

  toggleDropdown(){
    document.getElementById("myDropdown").classList.toggle("show");
  }

  filterDropdown() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("searchArea");
    filter = input.value.toUpperCase();
    var div = document.getElementById("myDropdown");
    li = div.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        if (li[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
  }

  public setUserBySearchBar(id){
    this.toggleDropdown();
    console.log("index for profile change:"+id)
    this.dataServ.changeData(this.searchData[id]);
    console.log(this.data);
    //this.dropdownDisabled = false;
    this.router.navigate(['profile', this.data.userPass.username]);
  }

  public fetchSearchUserById(name) {
    console.log(name.control.value);
    this.conn.getSearchUserById(name.control.value).subscribe(
      data => {
        this.dataServ.changeData(data);
        if (data != null) {
          //this.dropdownDisabled = false;
          console.log(data);
          this.router.navigate(['profile', data.userPass.username]);
        }
      },
      error => {
        console.log('ERROR', error);
      }
    );
  }


  logout() {
    console.log('NavbarComponent: logout()');
    localStorage.removeItem('userid');
    localStorage.removeItem('role');

    this.loginService.logout().subscribe (
      PASS => {
        console.log(PASS);
        this.router.navigate(['/login']);
      },
      FAIL => { console.log(FAIL); }
    );
  }
}
