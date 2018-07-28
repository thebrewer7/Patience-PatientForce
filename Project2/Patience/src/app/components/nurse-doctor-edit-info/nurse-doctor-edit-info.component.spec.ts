import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NurseDoctorEditInfoComponent } from './nurse-doctor-edit-info.component';

describe('NurseDoctorEditInfoComponent', () => {
  let component: NurseDoctorEditInfoComponent;
  let fixture: ComponentFixture<NurseDoctorEditInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NurseDoctorEditInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NurseDoctorEditInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
