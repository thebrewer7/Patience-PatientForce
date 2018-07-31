import { TestBed, inject } from '@angular/core/testing';

import { DoctoreditinfoService } from './doctoreditinfo.service';

describe('DoctoreditinfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DoctoreditinfoService]
    });
  });

  it('should be created', inject([DoctoreditinfoService], (service: DoctoreditinfoService) => {
    expect(service).toBeTruthy();
  }));
});
