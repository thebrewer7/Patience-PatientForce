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

  constructor(private conn: ConnectorService, private dataServ: UserDataService, private loginService: LoginService, private router: Router) {
    
  }

  ngOnInit() {
    this.dataServ.currentData.subscribe(data => this.data = data);
  }

  public fetchSearchFill() {
    this.searchData = null;
    // this.conn.getSearchFill().subscribe(
    //     data => {
    //       this.searchData = data;
    //       console.log(this.searchData);
    //       this.toggleDropdown();
    //     },
    //     error => {
    //       console.log('ERROR', error);
    //     }
    //   );
  }

  toggleDropdown(){
    document.getElementById("myDropdown").classList.toggle("show");
  }

  filterDropdown() {
    this.toggleDropdown();
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
    this.router.navigate(['profile']);
  }

  public fetchSearchUserById(name) {
    console.log(name.control.value);
    this.conn.getSearchUserById(name.control.value).subscribe(
      data => {
        this.dataServ.changeData(data);
        this.router.navigate(['profile', data.userPass.username]);
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
