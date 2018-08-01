import { Patient } from '../app/objects/patient';

export const PATIENTS: Patient[] = [
    {id: 1, name: 'Logan', role: 'Patient', location: '1st floor', status: 'moving', condition: 'undetermined', preferredDoctor: 'Ray', nurses: [], doctors: [], users: [], locked: false },
    {id: 2, name: 'Andrew', role: 'Patient', location: '2nd floor', status: 'sitting', condition: 'good', preferredDoctor: 'Ray', nurses: [], doctors: [], users: [], locked: false },
    {id: 3, name: 'Ray', role: 'Patient', location: '3rd floor', status: 'climbing', condition: 'fair', preferredDoctor: 'Ray', nurses: [], doctors: [], users: [], locked: false },
    {id: 4, name: 'Austin', role: 'Patient', location: '4th floor', status: 'running', condition: 'serious', preferredDoctor: 'Ray', nurses: [], doctors: [], users: [], locked: false },
    {id: 5, name: 'Bobbert', role: 'Patient', location: '5th floor', status: 'walking', condition: 'critical', preferredDoctor: 'Ray', nurses: [], doctors: [], users: [], locked: false },
]