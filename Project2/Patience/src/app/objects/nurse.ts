import { Review } from './review';
import { Doctor } from './doctor';

export class Nurse  {
  id: number;
  name: string;
  role: string;
  certifications: string[];
  department: string;
  rating: number;
  reviews: Review[];
  doctors: Doctor[];
  locked: boolean;
}
