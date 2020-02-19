import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerCancelOrderComponent } from './customer-cancel-order.component';

describe('CustomerCancelOrderComponent', () => {
  let component: CustomerCancelOrderComponent;
  let fixture: ComponentFixture<CustomerCancelOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerCancelOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerCancelOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
