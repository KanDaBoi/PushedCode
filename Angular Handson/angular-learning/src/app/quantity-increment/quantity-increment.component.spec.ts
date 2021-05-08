import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuantityIncrementComponent } from './quantity-increment.component';

import { FormsModule } from '@angular/forms';
import { DebugElement } from '@angular/core';

describe('QuantityIncrementComponent', () => {
  let component: QuantityIncrementComponent;
  let fixture: ComponentFixture<QuantityIncrementComponent>;
  let debugElement:DebugElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuantityIncrementComponent ],
      imports: [ FormsModule ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuantityIncrementComponent);
    component = fixture.componentInstance;
    debugElement = fixture.debugElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should give string ',() => {
    let clickMeButton = debugElement.nativeElement.querySelector('#clickMe');
    clickMeButton.click();
    fixture.detectChanges();
    expect(debugElement.nativeElement.querySelector('#simpleClick').textContent).toEqual('Click me button clicked!');
  });
});
