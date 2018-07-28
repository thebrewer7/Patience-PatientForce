import { Patient } from './patient';

export class User {
  id: number;
  name: string;
  role: string;
  lastLoggedIn: String;
  patients: Patient[];
}
