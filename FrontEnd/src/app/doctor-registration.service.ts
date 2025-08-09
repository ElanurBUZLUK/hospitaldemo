import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DoctorRegistrationService {
  private readonly baseUrl = `${environment.apiUrl}/doctors`;

  constructor(private http: HttpClient) {}

  public doDocRegistration(doctor: any) {
    return this.http.post(`${this.baseUrl}`, doctor, { responseType: 'text' as 'json' });
  }

  public getAllDoctors() {
    return this.http.get(`${this.baseUrl}`);
  }

  public getDoctorbyId(doctId: number) {
    return this.http.get(`${this.baseUrl}/${doctId}`);
  }

  public getDoctorbyName(docName: string) {
    return this.http.get(`${this.baseUrl}/docName/${encodeURIComponent(docName)}`);
  }

  public updateADoctor(id: number, doctor: any) {
    return this.http.put(`${this.baseUrl}/${id}`, doctor, { responseType: 'text' as 'json' });
  }

  public deleteADoctor(doctId: number) {
    return this.http.delete(`${this.baseUrl}/${doctId}`);
  }
}
