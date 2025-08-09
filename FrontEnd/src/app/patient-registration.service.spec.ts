import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PatientRegistrationService } from './patient-registration.service';

describe('PatientRegistrationService', () => {
  let service: PatientRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PatientRegistrationService]
    });
    service = TestBed.inject(PatientRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
