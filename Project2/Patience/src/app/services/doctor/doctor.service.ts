import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Review } from '../../objects/review';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) {}

  getPatients() {
    const params = new HttpParams();
    return this.http.post('http://localhost:8085/PatienceMavenProject/getAllDoctorsPatients.do', params);
  }

  getReviews(username: string) {
    console.log('DoctorService: getReviews()');
    return this.http.post<Review[]>('http://localhost:8085/PatienceMavenProject/getDoctorsReviews.do', {username: username});
  }
}
