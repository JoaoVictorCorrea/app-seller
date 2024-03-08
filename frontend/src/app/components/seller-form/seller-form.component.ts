import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-seller-form',
  templateUrl: './seller-form.component.html',
  styleUrl: './seller-form.component.css'
})
export class SellerFormComponent implements OnChanges {

  @Input()
  seller : Seller = {} as Seller;
  
  @Output()
  saveEmitter = new EventEmitter();

  formGroupSeller: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.formGroupSeller = this.formBuilder.group({
      id: {value:null, disabled:true},
      name: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(255)]],
      salary: ['', [Validators.required, Validators.min(1)]],
      bonus: ['', [Validators.required, Validators.min(0), Validators.max(100)]],
      gender: ['', [Validators.required]]
    })
  }

  ngOnChanges(): void {
    if(this.seller.id)
      this.formGroupSeller.setValue(this.seller);
  }

  save() {
    if (this.formGroupSeller.valid) {
      Object.assign(this.seller, this.formGroupSeller.value); //faz a conversão do formGroup para o Seller
      this.saveEmitter.emit(true);
    }
  }

  cancel() {
    this.saveEmitter.emit(false);
  }

  get sfgName() { return this.formGroupSeller.get("name") }
  get sfgSalary() { return this.formGroupSeller.get("salary") }
  get sfgBonus() { return this.formGroupSeller.get("bonus") }
  get sfgGender() {return this.formGroupSeller.get("gender")}
}