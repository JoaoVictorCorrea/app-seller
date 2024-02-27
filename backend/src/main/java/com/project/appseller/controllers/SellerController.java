package com.project.appseller.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.appseller.models.Seller;
import com.project.appseller.services.SellerService;

@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;
    
    @GetMapping
    public ResponseEntity<List<Seller>> getSellers() {
        
        return ResponseEntity.ok(sellerService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable long id) {

        Seller seller = sellerService.getById(id);
        
        return ResponseEntity.ok(seller);
    }

    @PostMapping
    public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
        
        Seller newSeller = sellerService.save(seller);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newSeller.getId())
                .toUri();

        return ResponseEntity.created(location).body(newSeller);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSeller(@PathVariable long id, @RequestBody Seller seller) {

        sellerService.updateById(id, seller);

        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeSeller(@PathVariable long id) {

        sellerService.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}
