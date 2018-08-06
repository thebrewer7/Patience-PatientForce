import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { History } from '../../objects/history';
@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  constructor(private http: HttpClient) {}

  getHistory(username: string) {
    const params = new HttpParams()
          .set('username', username);

    return this.http.post<History>('http://localhost:8085/PatienceMavenProject/getHistory.do', params);
  }

}
