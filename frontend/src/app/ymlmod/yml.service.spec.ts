import { TestBed } from '@angular/core/testing';

import { YmlService } from './yml.service';

describe('YmlService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: YmlService = TestBed.get(YmlService);
    expect(service).toBeTruthy();
  });
});
