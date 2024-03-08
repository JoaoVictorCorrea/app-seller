import { Injectable } from '@angular/core';
import { Seller } from '../interfaces/Seller';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private http: HttpClient) { }

  getSellers(): Observable<Seller[]>{
    return this.http.get<Seller[]>("http://localhost:8080/sellers");
  }

  saveSeller(seller: Seller) {
    return this.http.post<Seller>("http://localhost:8080/sellers", seller);
  }

  updateSeller(seller: Seller) {
    return this.http.put<Seller>(`http://localhost:8080/sellers/${seller.id}`, seller);
  }

  deleteSeller(seller: Seller) {
    return this.http.delete<void>(`http://localhost:8080/sellers/${seller.id}`);
  }
}
