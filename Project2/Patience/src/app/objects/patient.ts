import { Nurse } from './nurse';
import { Doctor } from './doctor';
import { User } from './user';

export class Patient {
  id: number;
  name: string;
  role: string;
  location: string;
  status: string;
  condition: string;
  preferredDoctor: string;
  nurses: Nurse[];
  doctors: Doctor[];
  users: User[];
  locked: boolean;
}
