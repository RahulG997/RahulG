import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorPendingHistoryComponent } from './vendor-pending-history.component';

describe('VendorPendingHistoryComponent', () => {
  let component: VendorPendingHistoryComponent;
  let fixture: ComponentFixture<VendorPendingHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorPendingHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorPendingHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
