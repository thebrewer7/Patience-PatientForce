import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Patient } from '../../objects/patient';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  getPatients() {

    const params = new HttpParams();

    return this.http.post('http://localhost:8085/PatienceMavenProject/getUsersPatients.do', params);
  }
}
