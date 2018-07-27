import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { DoctorPageComponent } from './components/doctor-page/doctor-page.component';
import { NursePageComponent } from './components/nurse-page/nurse-page.component';
import { PatientPageComponent } from './components/patient-page/patient-page.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { LoginPageComponent} from './components/login-page/login-page.component';

const routes: Routes = [
    {
        path: 'adminpage',
        component: AdminPageComponent
    },
    {
        path: 'doctorpage',
        component: DoctorPageComponent
    },
    {
        path: 'nursepage',
        component: NursePageComponent
    },
    {
        path: 'patientpage',
        component: PatientPageComponent
    },
    {
        path: 'userpage',
        component: UserPageComponent
    },
    {
      path: 'login',
      component: LoginPageComponent
  }
];

@NgModule({
   imports: [RouterModule.forRoot(routes)],
   exports: [RouterModule],
})
export class AppRoutingModule { }

export const routingComponents = [
    AdminPageComponent,
    DoctorPageComponent,
    NursePageComponent,
    PatientPageComponent,
    UserPageComponent,
    LoginPageComponent
];
