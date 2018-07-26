import { Routes } from '@angular/router';

import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { DoctorPageComponent } from './components/doctor-page/doctor-page.component';
import { NursePageComponent } from './components/nurse-page/nurse-page.component';
import { PatientPageComponent } from './components/patient-page/patient-page.component';
import { UserPageComponent } from './components/user-page/user-page.component';

export const approutes: Routes = [
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
        path: '',
        redirectTo: '/adminpage',
        pathMatch: 'full'
    },
    { 
        path: '**', 
        component: AdminPageComponent 
    }
]