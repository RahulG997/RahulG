import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CMSMainComponent } from './cmsmain.component';

describe('CMSMainComponent', () => {
  let component: CMSMainComponent;
  let fixture: ComponentFixture<CMSMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CMSMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CMSMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
