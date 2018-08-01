import { Patient } from '../app/objects/patient';

export const PATIENTS: Patient[] = [
    {id: 1, name: 'Logan', role: 'Patient', location: '1st floor', status: 'moving', condition: 'undetermined', preferredDoctor: 'Ray', nurses: [
        {id: 1, name: 'Nurse1', role: 'Nurse', certifications: [], rating: 5, reviews: [], department: '1', patients: [], locked: false },
        {id: 2, name: 'Nurse2', role: 'Nurse', certifications: [], rating: 1, reviews: [], department: '1', patients: [], locked: false }
    ], doctors: [
        {id: 1, name: 'Doctor1', role: 'Doctor', certifications: [], degrees: [], experience: '1 day', rating: 3, reviews: [], department: '1', patients: [], locked: false },
        {id: 2, name: 'Doctor2', role: 'Doctor', certifications: [], degrees: [], experience: '30 days', rating: 1, reviews: [], department: '1', patients: [], locked: false },
    ], users: [], locked: false },
    {id: 2, name: 'Andrew', role: 'Patient', location: '2nd floor', status: 'sitting', condition: 'good', preferredDoctor: 'Ray', nurses: [
        {id: 3, name: 'Nurse3', role: 'Nurse', certifications: [], rating: 3, reviews: [], department: '1', patients: [], locked: false },
        {id: 4, name: 'Nurse4', role: 'Nurse', certifications: [], rating: 4, reviews: [], department: '1', patients: [], locked: false },
    ], doctors: [
        {id: 3, name: 'Doctor3', role: 'Doctor', certifications: [], degrees: [], experience: '6 months', rating: 5, reviews: [], department: '1', patients: [], locked: false },
        {id: 4, name: 'Doctor4', role: 'Doctor', certifications: [], degrees: [], experience: '1 year', rating: 2, reviews: [], department: '1', patients: [], locked: false },
    ], users: [], locked: false },
    {id: 3, name: 'Ray', role: 'Patient', location: '3rd floor', status: 'climbing', condition: 'fair', preferredDoctor: 'Ray', nurses: [
        {id: 5, name: 'Nurse5', role: 'Nurse', certifications: [], rating: 2, reviews: [], department: '1', patients: [], locked: false },
        {id: 6, name: 'Nurse6', role: 'Nurse', certifications: [], rating: 5, reviews: [], department: '1', patients: [], locked: false },
    ], doctors: [
        {id: 5, name: 'Doctor5', role: 'Doctor', certifications: [], degrees: [], experience: '2 years', rating: 4, reviews: [], department: '1', patients: [], locked: false },
        {id: 6, name: 'Doctor6', role: 'Doctor', certifications: [], degrees: [], experience: '5 day', rating: 3, reviews: [], department: '1', patients: [], locked: false },
    ], users: [], locked: false },
    {id: 4, name: 'Austin', role: 'Patient', location: '4th floor', status: 'running', condition: 'serious', preferredDoctor: 'Ray', nurses: [
        {id: 7, name: 'Nurse7', role: 'Nurse', certifications: [], rating: 1, reviews: [], department: '1', patients: [], locked: false },
        {id: 8, name: 'Nurse8', role: 'Nurse', certifications: [], rating: 3, reviews: [], department: '1', patients: [], locked: false },
    ], doctors: [
        {id: 7, name: 'Doctor7', role: 'Doctor', certifications: [], degrees: [], experience: '30 years', rating: 1, reviews: [], department: '1', patients: [], locked: false },
        {id: 8, name: 'Doctor8', role: 'Doctor', certifications: [], degrees: [], experience: '10 months', rating: 5, reviews: [], department: '1', patients: [], locked: false },
    ], users: [], locked: false },
    {id: 5, name: 'Bobbert', role: 'Patient', location: '5th floor', status: 'walking', condition: 'critical', preferredDoctor: 'Ray', nurses: [
        {id: 9, name: 'Nurse9', role: 'Nurse', certifications: [], rating: 4, reviews: [], department: '1', patients: [], locked: false },
        {id: 10, name: 'Nurse10', role: 'Nurse', certifications: [], rating: 2, reviews: [], department: '1', patients: [], locked: false }
    ], doctors: [
        {id: 9, name: 'Doctor9', role: 'Doctor', certifications: [], degrees: [], experience: '4 months', rating: 2, reviews: [], department: '1', patients: [], locked: false },
        {id: 10, name: 'Doctor10', role: 'Doctor', certifications: [], degrees: [], experience: '100 years', rating: 4, reviews: [], department: '1', patients: [], locked: false }
    ], users: [], locked: false }
]