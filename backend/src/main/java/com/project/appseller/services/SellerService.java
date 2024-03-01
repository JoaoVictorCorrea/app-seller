package com.project.appseller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.appseller.dtos.SellerRequestDTO;
import com.project.appseller.dtos.SellerResponseDTO;
import com.project.appseller.models.Seller;
import com.project.appseller.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerResponseDTO> getAll() {

        return sellerRepository.findAll()
                               .stream()
                               .map(s -> s.toDTO())
                               .toList();
    }
    
    public SellerResponseDTO getById(long id) {

        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found"));

        return seller.toDTO();
    }
    
    public SellerResponseDTO save(SellerRequestDTO seller) {

        Seller newSeller = sellerRepository.save(seller.toEntity());

        return newSeller.toDTO();
    }
    
    public void updateById(long id, SellerRequestDTO sellerUpdate) {

        try{
            Seller seller = sellerRepository.getReferenceById(id);
            seller.setName(sellerUpdate.getName());
            seller.setSalary(sellerUpdate.getSalary());
            seller.setBonus(sellerUpdate.getBonus());
            seller.setGender(sellerUpdate.getGender());

            sellerRepository.save(seller);
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Seller not found");
        }
    }
    
    public void deleteById(long id) {
        
        getById(id);
        sellerRepository.deleteById(id);
    }
}
