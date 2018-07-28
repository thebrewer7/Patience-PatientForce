/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { NurseService } from './nurse.service';

describe('Service: Nurse', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NurseService]
    });
  });

  it('should ...', inject([NurseService], (service: NurseService) => {
    expect(service).toBeTruthy();
  }));
});
