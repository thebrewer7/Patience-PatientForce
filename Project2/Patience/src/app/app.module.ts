import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {APP_BASE_HREF} from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { LoginComponent } from './components/login/login.component';
import { LoginPageComponent} from './components/login-page/login-page.component';
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
import { ConnectorService } from './services/connector/connector.service';

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
    ProfileDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BsDropdownModule.forRoot(),
    FormsModule,
    HttpClientModule
  ],
  providers: [AppComponent, routingComponents,
             {provide: APP_BASE_HREF, useValue: '/Patience/'},
            ConnectorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
