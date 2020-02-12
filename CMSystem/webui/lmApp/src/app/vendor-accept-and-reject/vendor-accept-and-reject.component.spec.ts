import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorAcceptAndRejectComponent } from './vendor-accept-and-reject.component';

describe('VendorAcceptAndRejectComponent', () => {
  let component: VendorAcceptAndRejectComponent;
  let fixture: ComponentFixture<VendorAcceptAndRejectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorAcceptAndRejectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorAcceptAndRejectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
