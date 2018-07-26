import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NursePageComponent } from './nurse-page.component';

describe('NursePageComponent', () => {
  let component: NursePageComponent;
  let fixture: ComponentFixture<NursePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NursePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NursePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
