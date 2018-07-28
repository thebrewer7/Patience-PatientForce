import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {}
  register(email: string, username: string, password: string, passwordconfirm: string) {
    console.log('RegistrationService: register()');
    return this.http.post<any>('http://localhost:8085/PatienceMavenProject/RegisterServlet', {email: email, username: username, password: password, passwordconfirm: passwordconfirm});
  }
}
