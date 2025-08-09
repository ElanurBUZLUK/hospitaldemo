import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorRegistrationComponent } from './doctor-registration/doctor-registration.component';
import { HomeComponent } from './home/home.component';
import { PatientRegistrationComponent } from './patient-registration/patient-registration.component';
import { ShowDoctorComponent } from './show-doctor/show-doctor.component';
import { ShowPatientComponent } from './show-patient/show-patient.component';

const routes: Routes = [

  { path: '', redirectTo: "home" , pathMatch:'full'},
  { path: 'home', component: HomeComponent },
  { path: 'docregister', component: DoctorRegistrationComponent },
  { path: 'patregistration', component: PatientRegistrationComponent },
  { path: 'doctinfo', component: ShowDoctorComponent },
  { path: 'patientinfo', component: ShowPatientComponent }
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
