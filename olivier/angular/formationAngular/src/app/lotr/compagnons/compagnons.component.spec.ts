import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompagnonsComponent } from './compagnons.component';

describe('CompagnonsComponent', () => {
  let component: CompagnonsComponent;
  let fixture: ComponentFixture<CompagnonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompagnonsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompagnonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
