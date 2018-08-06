import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from '../../objects/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {}

  register(username: string, password: string, passwordconfirm: string) {
    const params = new HttpParams().set('username', username).set('password', password);
    return this.http.post<User>('http://34.207.69.111:8085/PatienceMavenProject/register.do', params);
  }
}
