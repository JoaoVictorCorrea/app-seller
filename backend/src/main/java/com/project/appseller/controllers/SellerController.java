package com.project.appseller.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.project.appseller.dtos.SellerRequestDTO;
import com.project.appseller.dtos.SellerResponseDTO;
import com.project.appseller.services.SellerService;

@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;
    
    @GetMapping
    public ResponseEntity<List<SellerResponseDTO>> getSellers() {
        
        return ResponseEntity.ok(sellerService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SellerResponseDTO> getSeller(@PathVariable long id) {

        SellerResponseDTO seller = sellerService.getById(id);
        
        return ResponseEntity.ok(seller);
    }

    @PostMapping
    public ResponseEntity<SellerResponseDTO> saveSeller(@Validated @RequestBody SellerRequestDTO seller) {
        
        SellerResponseDTO newSeller = sellerService.save(seller);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newSeller.getId())
                .toUri();

        return ResponseEntity.created(location).body(newSeller);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSeller(@PathVariable long id, @Validated @RequestBody SellerRequestDTO seller) {

        sellerService.updateById(id, seller);

        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeSeller(@PathVariable long id) {

        sellerService.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}
