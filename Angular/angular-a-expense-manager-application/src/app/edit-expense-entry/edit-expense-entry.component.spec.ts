import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditExpenseEntryComponent } from './edit-expense-entry.component';

describe('EditExpenseEntryComponent', () => {
  let component: EditExpenseEntryComponent;
  let fixture: ComponentFixture<EditExpenseEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditExpenseEntryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditExpenseEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
