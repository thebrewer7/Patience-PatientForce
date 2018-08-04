import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  constructor(private http: HttpClient) {}

  getHistory() {
    const params = new HttpParams();
    return this.http.post<History[]>('http://18.205.153.39:8085/PatienceMavenProject/getHistory.do', params);
  }

}
