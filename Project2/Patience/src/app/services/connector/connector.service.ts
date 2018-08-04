import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { of } from 'rxjs';
import { Review } from '../../objects/review';

@Injectable({
  providedIn: 'root'
})
export class ConnectorService {
  constructor(private http: HttpClient) { }

  getSearchFill() {
    return this.http.get("http://18.205.153.39:8085/PatienceMavenProject/SearchFill.do", { responseType: 'text' });
  }

  getSearchUserById(name) {
    var params = new HttpParams();
    params = params.append("name", name);

    return this.http.get("http://18.205.153.39:8085/PatienceMavenProject/SearchResults.do", {params: params});

  }

  submitReviewByName(rating, review) {
    console.log("rating: "+rating);
    console.log("review: "+review);

    var params = new HttpParams();
    params = params.append("rating", rating);
    params = params.append("review", review);

    return this.http.get("http://18.205.153.39:8085/PatienceMavenProject/SubmitReview.do", { responseType: 'text', params: params });
  }

  getReviewByName(id, role) {
    var params = new HttpParams();
    params = params.append("id", id);
    params = params.append("role", role);

    return this.http.get<Review[]>("http://18.205.153.39:8085/PatienceMavenProject/GetReviews.do", { params: params });
  }
}
