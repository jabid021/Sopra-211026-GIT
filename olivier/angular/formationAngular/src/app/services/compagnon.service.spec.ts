import { TestBed } from '@angular/core/testing';

import { CompagnonService } from './compagnon.service';

describe('CompagnonService', () => {
  let service: CompagnonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompagnonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
