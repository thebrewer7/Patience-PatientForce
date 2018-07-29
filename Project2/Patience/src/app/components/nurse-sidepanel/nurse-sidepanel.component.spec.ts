import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NurseSidepanelComponent } from './nurse-sidepanel.component';

describe('NurseSidepanelComponent', () => {
  let component: NurseSidepanelComponent;
  let fixture: ComponentFixture<NurseSidepanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NurseSidepanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NurseSidepanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
