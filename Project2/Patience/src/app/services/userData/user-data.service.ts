import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Details } from '../../objects/details';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  private dataSource = new BehaviorSubject(new Details);
  currentData = this.dataSource.asObservable();

  constructor() { }

  changeData(data: Details) {
    this.dataSource.next(data);
  }
}
