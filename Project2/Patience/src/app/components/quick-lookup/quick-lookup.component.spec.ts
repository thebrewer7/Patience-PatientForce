import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuickLookupComponent } from './quick-lookup.component';

describe('QuickLookupComponent', () => {
  let component: QuickLookupComponent;
  let fixture: ComponentFixture<QuickLookupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuickLookupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuickLookupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
