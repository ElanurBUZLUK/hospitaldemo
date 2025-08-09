import { List } from "postcss/lib/list";

export class Patient {
    patientName: string;
    dateOfVisit: string;
    visitedDoctor: string;
    precription: string;
    doctorId: number;
    city: string;      // Şehir alanı eklendi
    district: string; // İlçe alanı eklendi

    constructor() {
        this.city = '';     // Varsayılan olarak boş bir değer verildi
        this.district = ''; // Varsayılan olarak boş bir değer verildi
    }
}
 
export interface District {
    id: number;
    name: string;
  }
  
  export interface City {
    id: number;
    name: string;
    districts: District[];
  }
  
