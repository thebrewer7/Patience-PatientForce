import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SbDropdownComponent } from './sb-dropdown.component';

describe('SbDropdownComponent', () => {
  let component: SbDropdownComponent;
  let fixture: ComponentFixture<SbDropdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SbDropdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SbDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
