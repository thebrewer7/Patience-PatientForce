import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Review } from '../../objects/review';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) {}

  getDoctors() {
    const params = new HttpParams();
    return this.http.post('http://18.208.144.106:8085/PatienceMavenProject/getDoctors.do', params);
  }

  getPatients() {
    const params = new HttpParams();
    return this.http.post('http://18.208.144.106:8085/PatienceMavenProject/getAllDoctorsPatients.do', params);
  }

  getReviews(username: string) {
    console.log('DoctorService: getReviews()');
    return this.http.post<Review[]>('http://18.208.144.106:8085/PatienceMavenProject/getDoctorsReviews.do', {username: username});
  }
}
