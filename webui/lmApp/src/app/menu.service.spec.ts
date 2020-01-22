import { TestBed } from '@angular/core/testing';

import { MenuServiceService } from './menu.service';

describe('MenuService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuServiceService = TestBed.get(MenuServiceService);
    expect(service).toBeTruthy();
  });
});
