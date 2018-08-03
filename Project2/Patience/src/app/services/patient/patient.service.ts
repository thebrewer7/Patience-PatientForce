import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Doctor } from '../../objects/doctor';
import { Nurse } from '../../objects/nurse';
import {Patient } from '../../objects/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) {}

  getDoctors(username: string) {
    console.log('PatientService: getPatients()');
    return this.http.post<Doctor[]>('http://34.205.71.228:8085/PatienceMavenProject/getPatientsDoctors.do', {username: username});
  }

  getNurses(username: string) {
    console.log('PatientService: getPatients()');
    return this.http.post<Nurse[]>('http://34.205.71.228:8085/PatienceMavenProject/getPatientsNurses.do', {username: username});
  }

  search(username: string) {
    console.log('PatientService: search()');
    const params = new HttpParams().set('username', username);
    return this.http.post<Patient>('http://34.205.71.228:8085/PatienceMavenProject/getPatient.do', params);
  }
}
