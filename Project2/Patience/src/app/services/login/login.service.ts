import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {}
  login(username: string, password: string) {
    console.log('LoginService: login()');
    return this.http.post<any>('http://localhost:8085/PatienceMavenProject/login.do', {username: username, password: password});
  }

  logout() {
    console.log('LoginService: logout()');
    return this.http.get<any>('http://localhost:8085/PatienceMavenProject/logout.do');
  }
}
