package com.example.SpringAPI.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringAPI.api.model.Product;
import com.example.SpringAPI.service.CrackerstoreService;

@RestController
@RequestMapping("/crackers_store")
public class ProductController {

    private final CrackerstoreService productService;

    @Autowired
    public ProductController(CrackerstoreService productService) {
        this.productService = productService;
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get list of product categories
    @GetMapping("/productsCategoryList")
    public ResponseEntity<List<String>> getProductsCategoryList() {
        List<String> categories = productService.getProductsCategoryList();
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(categories);
    }

    // Get products by category
    @GetMapping("/productsListGivenACategory")
    public ResponseEntity<List<Product>> getProductsListGivenACategory(@RequestParam String category) {
        List<Product> products = productService.getProductsByCategory(category);
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(products);
    }

    // Get list of offers
    @GetMapping("/offersList")
    public ResponseEntity<List<String>> getOffersList() {
        List<String> offers = productService.getOffers();
        if (offers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(offers);
    }
}
