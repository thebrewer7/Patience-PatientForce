import { Review } from './review';
import { Patient } from './patient';
import { UserPass } from './userpass';

export class Doctor {
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
  locked: boolean;
  userPass: UserPass;
}
