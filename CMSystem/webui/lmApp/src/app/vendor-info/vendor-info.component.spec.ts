import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorInfoComponent } from './vendor-info.component';

describe('VendorInfoComponent', () => {
  let component: VendorInfoComponent;
  let fixture: ComponentFixture<VendorInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
