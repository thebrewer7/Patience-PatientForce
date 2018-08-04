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
    return this.http.post<Doctor[]>('http://18.205.153.39:8085/PatienceMavenProject/getDoctors.do', params);
  }

  getPatients() {
    const params = new HttpParams();
    return this.http.post<Patient[]>('http://18.205.153.39:8085/PatienceMavenProject/getAllDoctorsPatients.do', params);
  }

  getReviews(username: string) {
    console.log('DoctorService: getReviews()');
    const params = new HttpParams().set('username', username);
    return this.http.post<Review[]>('http://18.205.153.39:8085/PatienceMavenProject/getDoctorsReviews.do', params);
  }
}
