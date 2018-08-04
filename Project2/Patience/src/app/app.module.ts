import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import {APP_BASE_HREF} from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { LoginComponent } from './components/login/login.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { PatientPageComponent } from './components/patient-page/patient-page.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { DoctorPageComponent } from './components/doctor-page/doctor-page.component';
import { NursePageComponent } from './components/nurse-page/nurse-page.component';
import { QuickLookupComponent } from './components/quick-lookup/quick-lookup.component';

import { AppRoutingModule, routingComponents } from './app.routing';
import { RaterComponent } from './components/rater/rater.component';
import { NurseDoctorEditInfoComponent } from './components/nurse-doctor-edit-info/nurse-doctor-edit-info.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { ProfileDetailsComponent } from './components/profile-details/profile-details.component';
import { DoctorSidepanelComponent } from './components/doctor-sidepanel/doctor-sidepanel.component';
import { NurseSidepanelComponent } from './components/nurse-sidepanel/nurse-sidepanel.component';

import { LoginService } from './services/login/login.service';
import { RegistrationService } from './services/registration/registration.service';
import { UserService } from './services/user/user.service';
import { PatientService } from './services/patient/patient.service';
import { NurseService } from './services/nurse/nurse.service';
import { DoctorService } from './services/doctor/doctor.service';
import { ConnectorService } from './services/connector/connector.service';
import { CookieService } from 'ngx-cookie-service';
import { MiniMenuComponent } from './components/mini-menu/mini-menu.component';
import { ProfileDetailsService } from './services/profiledetails/profiledetails.service';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    UserPageComponent,
    PatientPageComponent,
    AdminPageComponent,
    DoctorPageComponent,
    NursePageComponent,
    RaterComponent,
    QuickLookupComponent,
    LoginPageComponent,
    NurseDoctorEditInfoComponent,
    ProfilePageComponent,
    ProfileDetailsComponent,
    DoctorSidepanelComponent,
    NurseSidepanelComponent,
    MiniMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BsDropdownModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    AppComponent,
    routingComponents,
    LoginService,
    RegistrationService,
    UserService,
    PatientService,
    NurseService,
    DoctorService,
    ConnectorService,
    CookieService,
    ProfileDetailsService,
    { provide: APP_BASE_HREF, useValue: '/Patience/' },
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
