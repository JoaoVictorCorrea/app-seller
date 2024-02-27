package com.project.appseller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.appseller.models.Seller;
import com.project.appseller.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAll() {

        return sellerRepository.findAll();
    }
    
    public Seller getById(long id) {

        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found"));

        return seller;
    }
    
    public Seller save(Seller seller) {

        Seller newSeller = sellerRepository.save(seller);

        return newSeller;
    }
    
    public void updateById(long id, Seller seller) {

        Seller sellerUpdate = sellerRepository.getReferenceById(id);
        sellerUpdate.setName(seller.getName());
        sellerUpdate.setSalary(seller.getSalary());
        sellerUpdate.setBonus(seller.getBonus());
        sellerUpdate.setGender(seller.getGender());

        save(sellerUpdate);
    }
    
    public void deleteById(long id) {
        
        getById(id);
        sellerRepository.deleteById(id);
    }
}
