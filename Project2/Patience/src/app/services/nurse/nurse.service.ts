import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Patient } from '../../objects/patient';
import { Review } from '../../objects/review';

@Injectable({
  providedIn: 'root'
})
export class NurseService {

  constructor(private http: HttpClient) {}

  getNurses() {
    const params = new HttpParams();
    return this.http.post('http://localhost:8085/PatienceMavenProject/getNurses.do', params);
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
