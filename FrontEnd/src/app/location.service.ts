import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

export interface DistrictDTO {
  districtId: number;
  districtName: string;
  cityId: number;
}

export interface CityDTO {
  cityId: number;
  cityName: string;
  districts?: DistrictDTO[];
}

@Injectable({ providedIn: 'root' })
export class LocationService {
  private readonly baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getCities(): Observable<CityDTO[]> {
    return this.http.get<CityDTO[]>(`${this.baseUrl}/cities`);
  }

  getDistrictsByCity(cityId: number): Observable<DistrictDTO[]> {
    return this.http.get<DistrictDTO[]>(`${this.baseUrl}/districts/byCity/${cityId}`);
  }
}


