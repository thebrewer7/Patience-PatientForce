import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {}
  login(username: string, password: string) {
    console.log('LoginService: login()');
    const params = new HttpParams().set('username', username).set('password', password);
    return this.http.post<any>('http://34.205.71.228:8085/PatienceMavenProject/login.do', params);
  }

  logout() {
    console.log('LoginService: logout()');
    return this.http.get<any>('http://34.205.71.228:8085/PatienceMavenProject/logout.do');
  }
}
