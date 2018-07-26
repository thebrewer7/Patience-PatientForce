import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { PatientPageComponent } from './components/patient-page/patient-page.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { DoctorPageComponent } from './components/doctor-page/doctor-page.component';
import { NursePageComponent } from './components/nurse-page/nurse-page.component';

@NgModule({
  declarations: [
    AppComponent,
    UserPageComponent,
    PatientPageComponent,
    AdminPageComponent,
    DoctorPageComponent,
    NursePageComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
