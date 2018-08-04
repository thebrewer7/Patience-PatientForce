import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Details } from '../../objects/details';

@Injectable({
  providedIn: 'root'
})

export class ProfileDetailsService {
  constructor(private http: HttpClient) {}

  getDetails(username) {
    const params = new HttpParams().set('username', username);
    return this.http.post<Details>('http://18.208.144.106:8085/PatienceMavenProject/getProfileDetails.do', params);
  }

}
