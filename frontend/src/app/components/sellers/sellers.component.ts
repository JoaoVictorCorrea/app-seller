import { Component } from '@angular/core';
import { Seller } from '../../interfaces/Seller';

@Component({
  selector: 'app-sellers',
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css'
})
export class SellersComponent {

  sellers: Seller[] = [
    {
      id: 1,
      name: "Seller1",
      salary: 1,
      bonus: 0.1,
      gender: 1
    },
    {
      id: 2,
      name: "Seller2",
      salary: 2,
      bonus: 0.2,
      gender: 0
    },
    {
      id: 3,
      name: "Seller3",
      salary: 3,
      bonus: 0.3,
      gender: 1
    }
  ]
}
