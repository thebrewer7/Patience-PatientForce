import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctoreditinfoService {

  constructor(private http: HttpClient) {}

  editPatient(patientid: number, patientlocation: string, patientstatus: string) {

    const params = new HttpParams()
      .set('patientid', patientid.toString())
      .set('patientlocation', patientlocation)
      .set('patientstatus', patientstatus);

    return this.http.post('http://18.208.144.106:8085/PatienceMavenProject/editDoctorsPatient.do', params);
  }
}
