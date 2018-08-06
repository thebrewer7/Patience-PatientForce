import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Patient } from '../../objects/patient';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  getPatients(username: string) {

    const params = new HttpParams()
          .set('username', username);

    return this.http.post<Patient[]>('http://localhost:8085/PatienceMavenProject/getUsersPatients.do', params);
  }
}
