import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Patient } from '../../objects/patient';
import { Review } from '../../objects/review';

@Injectable({
  providedIn: 'root'
})
export class NurseService {

  constructor(private http: HttpClient) {}

  getPatients(username: string) {
    console.log('NurseService: getPatients()');
    return this.http.post<Patient[]>('http://localhost:8085/PatienceMavenProject/getNursesPatients.do', {username: username});
  }

  getReviews(username: string) {
    console.log('NurseService: getReviews()');
    return this.http.post<Review[]>('http://localhost:8085/PatienceMavenProject/getNursesReviews.do', {username: username});
  }

  getNursesDoctors()
  {
    const params = new HttpParams();
    return this.http.post('http://localhost:8085/PatienceMavenProject/getNursesDoctors.do', params);
  }
}
