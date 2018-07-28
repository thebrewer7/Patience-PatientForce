import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnectorService {
  constructor(private http: HttpClient) { }

  getSearchResults() {
    return this.http.get("http://localhost:8085/PatienceMavenProject/SearchResults.do", { responseType: 'text' })
      .pipe(
        tap(
          data => {
            console.log(data);
          },
          error => {
            console.log("ERROR", error);
          }
        )
      );
  }
}
