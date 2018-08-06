import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Review } from '../../objects/review';
import { Doctor } from '../../objects/doctor';
import { Patient } from '../../objects/patient';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) {}

  getDoctors() {
    const params = new HttpParams();
    return this.http.post<Doctor[]>('http://localhost:8085/PatienceMavenProject/getDoctors.do', params);
  }

  getPatients() {
    const params = new HttpParams();
    return this.http.post<Patient[]>('http://localhost:8085/PatienceMavenProject/getAllDoctorsPatients.do', params);
  }

  getReviews(username: string) {
    const params = new HttpParams().set('username', username);
    return this.http.post<Review[]>('http://localhost:8085/PatienceMavenProject/getDoctorsReviews.do', params);
  }
}
