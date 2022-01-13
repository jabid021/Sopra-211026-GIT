import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCompagnonComponent } from './edit-compagnon.component';

describe('EditCompagnonComponent', () => {
  let component: EditCompagnonComponent;
  let fixture: ComponentFixture<EditCompagnonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCompagnonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCompagnonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
