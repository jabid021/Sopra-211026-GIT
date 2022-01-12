import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationParLeCodeComponent } from './navigation-par-le-code.component';

describe('NavigationParLeCodeComponent', () => {
  let component: NavigationParLeCodeComponent;
  let fixture: ComponentFixture<NavigationParLeCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavigationParLeCodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationParLeCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
