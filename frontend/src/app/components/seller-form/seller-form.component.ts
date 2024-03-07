import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Seller } from '../../interfaces/Seller';

@Component({
  selector: 'app-seller-form',
  templateUrl: './seller-form.component.html',
  styleUrl: './seller-form.component.css'
})
export class SellerFormComponent {

  @Input()
  seller?: Seller;
  
  @Output()
  saveEmitter = new EventEmitter();

  save() {
    this.saveEmitter.emit();
  }
}
