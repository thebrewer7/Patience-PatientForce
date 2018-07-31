import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctoreditinfoService {

  constructor(private http: HttpClient) {}

  editPatient(patientid: number) {

    const params = new HttpParams()
      .set('patientid', patientid.toString());

    return this.http.post('http://localhost:8085/PatienceMavenProject/editDoctorsPatient.do', params);
  }
}
