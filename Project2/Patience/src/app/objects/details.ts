import { Review } from './review';
import { Patient } from './patient';
import { UserPass } from './userpass';

export class Details {
    id: number; 
    name: string; 
    role: string; 
    certifications: string[]; 
    degrees: string[];
    experience: string; 
    rating: number;
    reviews: Review[];
    department: string;
    patients: Patient[];
    userPass: UserPass;
}