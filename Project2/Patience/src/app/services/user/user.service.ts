import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../../objects/patient';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  getPatients(username: string) {
    console.log('UserService: getPatients()');
    return this.http.post<Patient[]>('http://localhost:8085/PatienceMavenProject/UserGetPatientsServlet', {username: username});
  }
}
