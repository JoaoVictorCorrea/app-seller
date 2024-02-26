package com.project.appseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.appseller.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}