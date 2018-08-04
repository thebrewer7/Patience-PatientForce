import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  constructor(private http: HttpClient) {}

  getAllAdminAccounts() {

    const params = new HttpParams();

    return this.http.post('http://18.208.144.106:8085/PatienceMavenProject/getAllAccounts.do', params);
  }

}
