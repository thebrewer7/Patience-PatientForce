import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorSidepanelComponent } from './doctor-sidepanel.component';

describe('DoctorSidepanelComponent', () => {
  let component: DoctorSidepanelComponent;
  let fixture: ComponentFixture<DoctorSidepanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorSidepanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorSidepanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
