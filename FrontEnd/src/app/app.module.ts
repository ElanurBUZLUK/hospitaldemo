import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorRegistrationComponent } from './doctor-registration/doctor-registration.component';
import { PatientRegistrationComponent } from './patient-registration/patient-registration.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // ReactiveFormsModule eklendi
import { ShowDoctorComponent } from './show-doctor/show-doctor.component';
import { DoctorRegistrationService } from './doctor-registration.service';
import { ShowPatientComponent } from './show-patient/show-patient.component';

@NgModule({
  declarations: [
    AppComponent,
    DoctorRegistrationComponent,
    PatientRegistrationComponent,
    HomeComponent,
    ShowDoctorComponent,
    ShowPatientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule // ReactiveFormsModule burada eklendi
  ],
  providers: [DoctorRegistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
