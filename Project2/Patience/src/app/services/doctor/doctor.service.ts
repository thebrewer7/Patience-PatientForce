import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../../objects/patient';
import { Review } from '../../objects/review';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) {}

  getPatients(username: string) {
    console.log('DoctorService: getPatients()');
    return this.http.post<Patient[]>('http://localhost:8085/PatienceMavenProject/getDoctorsPatients.do', {username: username});
  }

  getReviews(username: string) {
    console.log('DoctorService: getReviews()');
    return this.http.post<Review[]>('http://localhost:8085/PatienceMavenProject/getDoctorsReviews.do', {username: username});
  }
}
