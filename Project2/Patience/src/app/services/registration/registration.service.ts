import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../objects/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {}
  register(email: string, username: string, password: string, passwordconfirm: string) {
    console.log('RegistrationService: register()');
    return this.http.post<User>('http://localhost:8085/PatienceMavenProject/register.do', {email: email, username: username, password: password, passwordconfirm: passwordconfirm});
  }
}
