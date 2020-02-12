import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPendingHistoryComponent } from './customer-pending-history.component';

describe('CustomerPendingHistoryComponent', () => {
  let component: CustomerPendingHistoryComponent;
  let fixture: ComponentFixture<CustomerPendingHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerPendingHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerPendingHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
