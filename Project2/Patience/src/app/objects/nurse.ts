import { Review } from './review';
import { Patient } from './patient';

export class Nurse  {
  id: number;
  name: string;
  role: string;
  certifications: string[];
  department: string;
  rating: number;
  reviews: Review[];
  patients: Patient[];
  locked: boolean;
}
