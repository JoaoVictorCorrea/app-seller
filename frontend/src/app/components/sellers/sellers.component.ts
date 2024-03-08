import { Component } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { SellerService } from '../../service/seller.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-sellers',
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css'
})
export class SellersComponent {

  sellers: Seller[] = [];
  seller: Seller = {} as Seller;
  deleteSeller: Seller = {} as Seller;

  showForm: boolean = false;
  isEditing: boolean = false;

  constructor(private sellerService: SellerService, private modalService: NgbModal) { }

  ngOnInit(): void{
    this.loadSellers();
  }

  //Métodos que alteram o comportamento da tela

  create() {
    this.showForm = true;
  }

  edit(seller: Seller) {
    this.seller = seller;
    this.showForm = true;
    this.isEditing = true;
  }

  //Requisções HTTP

  loadSellers() {
    this.sellerService.getSellers().subscribe(
      {
        next: data => {this.sellers = data}
      });
  }

  save(save: boolean) {
    if (save) {
      if (this.isEditing) {
        this.sellerService.updateSeller(this.seller).subscribe();
      }
      else {
        this.sellerService.saveSeller(this.seller).subscribe(
          {
            next: data => {
              this.sellers.push(data);
            }
          });
      }
    }

    this.seller = {} as Seller;
    this.showForm = false;
    this.isEditing = false;
  }

  delete(modal: any, seller: Seller) {
    this.deleteSeller = seller;

    this.modalService.open(modal).result.then(
      (confirm) => {
        if (confirm) {
          this.sellerService.deleteSeller(seller).subscribe(
            {   
              next: () => {
                this.sellers = this.sellers.filter(s => s.id !== seller.id);
              }
            });
        }
      });
    }
}
