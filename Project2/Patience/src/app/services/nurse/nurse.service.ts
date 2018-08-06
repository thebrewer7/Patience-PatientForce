import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Patient } from '../../objects/patient';
import { Review } from '../../objects/review';
import { Nurse } from '../../objects/nurse';
import { Doctor } from '../../objects/doctor';

@Injectable({
  providedIn: 'root'
})
export class NurseService {

  constructor(private http: HttpClient) {}

  getNurses() {
    const params = new HttpParams();
    return this.http.post<Nurse[]>('http://localhost:8085/PatienceMavenProject/getNurses.do', params);
  }

  getReviews(username: string) {
    const params = new HttpParams().set('username', username);
    return this.http.post<Review[]>('http://localhost:8085/PatienceMavenProject/getNursesReviews.do', params);
  }

  getNursesDoctors() {
    const params = new HttpParams();
    return this.http.post<Doctor[]>('http://localhost:8085/PatienceMavenProject/getNursesDoctors.do', params);
  }
}
