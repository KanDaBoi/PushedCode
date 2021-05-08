import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quantity-selector',
  templateUrl: './quantity-selector.component.html',
  styleUrls: ['./quantity-selector.component.css']
})
export class QuantitySelectorComponent implements OnInit {
  counter: number = 0;
  constructor() { }

  ngOnInit(): void {
  }
  onDecrement(): void {
    this.counter --;
  }
  onIncrement(): void {
    this.counter ++;
  }
}
