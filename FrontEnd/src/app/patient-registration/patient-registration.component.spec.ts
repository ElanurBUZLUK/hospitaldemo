import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing'; // 👈 EKLENDİ
import { PatientRegistrationComponent } from './patient-registration.component';
import { PatientRegistrationService } from '../patient-registration.service'; // 👈 EKLENDİ

describe('PatientRegistrationComponent', () => {
  let component: PatientRegistrationComponent;
  let fixture: ComponentFixture<PatientRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PatientRegistrationComponent],
      imports: [ReactiveFormsModule, HttpClientTestingModule], // 👈 İKİSİ DE
      providers: [PatientRegistrationService] // 👈 EKLENDİ
    }).compileComponents();

    fixture = TestBed.createComponent(PatientRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
