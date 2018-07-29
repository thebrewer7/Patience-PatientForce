import { Review } from './review';
import { Patient } from './patient';

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
}
