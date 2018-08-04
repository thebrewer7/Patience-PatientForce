import { Patient } from './patient';
import { UserPass } from './userpass';

export class User {
  id: number;
  name: string;
  role: string;
  lastLoggedIn: String;
  patients: Patient[];
  locked: boolean;
  userPass: UserPass;
}
