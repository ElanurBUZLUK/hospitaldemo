import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DoctorRegistrationService } from '../doctor-registration.service';
import { PatientRegistrationService } from '../patient-registration.service';
import { LocationService, CityDTO, DistrictDTO } from '../location.service';


@Component({
  selector: 'app-patient-registration',
  templateUrl: './patient-registration.component.html',
  styleUrls: ['./patient-registration.component.css']
})
export class PatientRegistrationComponent implements OnInit {

  patientForm: FormGroup;
  message: string = '';
  doctors: any[] = [];
  cities: CityDTO[] = [];
  availableDistricts: DistrictDTO[] = [];

  constructor(
    private fb: FormBuilder,
    private patService: PatientRegistrationService,
    private doctorService: DoctorRegistrationService,
    private locationService: LocationService
  ) {
    this.patientForm = this.fb.group({
      patientId: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      patientName: ['', [Validators.required, Validators.minLength(3)]],
      dateOfVisit: ['', Validators.required],
      prescription: [''],
      doctorId: ['', Validators.required],
      city: [null, Validators.required],        // City nesnesi tutulur
      district: [null, Validators.required]     // District nesnesi tutulur
    });
  }

  ngOnInit(): void {
    this.loadDoctors();
    this.loadCities();
  }

  loadDoctors(): void {
    this.doctorService.getAllDoctors().subscribe(
      (data: any) => this.doctors = data,
      (error: any) => console.error('Doktorları yüklerken hata oluştu:', error)
    );
  }

/*  addPhoneNumberField(): void {
    this.phoneNumbers.push(this.createPhoneNumberField());
  }

  createPhoneNumberField(): FormControl {
    return this.fb.control('', [Validators.required, Validators.pattern('^[0-9]*$')]);  // Sayısal doğrulama
  } */
  loadCities(): void {
    this.locationService.getCities().subscribe(
      (data) => {
        this.cities = data;
      },
      (error) => console.error('Şehirler alınamadı', error)
    );
  }

  onCityChange(): void {
    const selectedCity: CityDTO | null = this.patientForm.get('city')?.value ?? null;
    this.availableDistricts = [];
    this.patientForm.patchValue({ district: null });
    if (selectedCity?.cityId != null) {
      this.locationService.getDistrictsByCity(selectedCity.cityId).subscribe(
        (districts) => (this.availableDistricts = districts),
        (error) => console.error('İlçeler alınamadı', error)
      );
    }
  }
    

  /* get phoneNumbers(): FormArray {
    return this.patientForm.get('phoneNumbers') as FormArray;
  } */

  registerPatNow(): void {
    if (this.patientForm.valid) {
      const payload = this.patientForm.value;
      this.patService.doPatRegistration(payload).subscribe(
        (data: any) => {
          this.message = 'Hasta kaydı başarılı!';
          this.patientForm.reset();  // Formu temizle
          this.availableDistricts = [];  // İlçeler listesini temizle
        /*  while (this.phoneNumbers.length > 1) {
            this.phoneNumbers.removeAt(1);  // Ekstra telefon numarası alanlarını temizle
          } */
        },
        (error: any) => {
          console.error('Hata oluştu:', error);
          this.message = 'Hasta kaydı sırasında bir hata oluştu. Lütfen tekrar deneyiniz.';
        }
      );
    } else {
      this.message = 'Lütfen tüm gerekli alanları doldurun.';
    }
  }
}
