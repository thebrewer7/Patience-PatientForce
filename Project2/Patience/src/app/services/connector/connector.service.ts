import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnectorService {
  constructor(private http: HttpClient) {}

  getSearchFill() {
    return this.http.get(
      'http://localhost:8085/PatienceMavenProject/SearchFill.do',
      { responseType: 'text' }
    );
  }

  getSearchUserById(id) {
    let params = new HttpParams();
    params = params.append('id', id);

    return this.http.get(
      'http://localhost:8085/PatienceMavenProject/SearchResults.do',
      { params: params }
    );
  }
}
