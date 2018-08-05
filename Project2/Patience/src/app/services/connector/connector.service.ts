import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { of } from 'rxjs';
import { Details } from '../../objects/details';
import { Review } from '../../objects/review';
import { SearchDetails } from '../../objects/searchDetails';

@Injectable({
  providedIn: 'root'
})
export class ConnectorService {
  constructor(private http: HttpClient) { }

  getSearchFill() {
    const params = new HttpParams();
    return this.http.post<Details[]>("http://localhost:8085//PatienceMavenProject/SearchFill.do", params);
  }

  getSearchUserById(name) {
    const params = new HttpParams().set('name', name);
    return this.http.post<Details>("http://localhost:8085//PatienceMavenProject/SearchResults.do", params);

  }

  submitReviewByName(rating, review, role, date, id) {
    console.log("rating: "+rating);
    console.log("review: "+review);

    var params = new HttpParams();
    params = params.append("rating", rating);
    params = params.append("review", review);
    params = params.append("role", role);
    params = params.append("date", date);
    params = params.append("id", id);

    return this.http.get("http://localhost:8085//PatienceMavenProject/SubmitReview.do", { responseType: 'text', params: params });
  }

  getReviewByName(id, role) {
    var params = new HttpParams();
    params = params.append("id", id);
    params = params.append("role", role);

    return this.http.get<Review[]>("http://localhost:8085//PatienceMavenProject/GetReviews.do", { params: params });
  }
}
