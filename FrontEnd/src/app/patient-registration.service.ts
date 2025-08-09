import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PatientRegistrationService {
  private readonly baseUrl = `${environment.apiUrl}/patients`;

  constructor(private http: HttpClient) {}

  doPatRegistration(patientData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, patientData, { responseType: 'text' as 'json' });
  }

  getPatientById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getAllPatients(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getPatientsByDoctor(doctorId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/byDoctor/${doctorId}`);
  }

  updatePatient(id: number, patientData: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, patientData, { responseType: 'text' as 'json' });
  }

  deletePatient(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' as 'json' });
  }
}
