import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseEntryComponent } from './expense-entry.component';

describe('ExpenseEntryComponent', () => {
  let component: ExpenseEntryComponent;
  let fixture: ComponentFixture<ExpenseEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpenseEntryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExpenseEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
