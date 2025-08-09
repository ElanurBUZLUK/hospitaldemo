import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorRegistrationService } from '../doctor-registration.service';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent implements OnInit {

  doctor:Doctor = new Doctor();
  
  message:any;
  constructor(private service:DoctorRegistrationService) { }

  ngOnInit(): void {
  }

  public registerDocNow(){
    let response = this.service.doDocRegistration(this.doctor);
    response.subscribe((data)=>this.message=data);

  }

}
