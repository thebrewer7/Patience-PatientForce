import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor } from '../../objects/doctor';
import { Nurse } from '../../objects/nurse';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) {}

  getDoctors(username: string) {
    console.log('PatientService: getPatients()');
    return this.http.post<Doctor[]>('http://localhost:8085/PatienceMavenProject/getPatientsDoctors.do', {username: username});
  }

  getNurses(username: string) {
    console.log('PatientService: getPatients()');
    return this.http.post<Nurse[]>('http://localhost:8085/PatienceMavenProject/getPatientsNurses.do', {username: username});
  }
}
