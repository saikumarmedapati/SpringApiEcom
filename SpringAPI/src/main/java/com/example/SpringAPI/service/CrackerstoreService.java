package com.example.SpringAPI.service;

import java.util.List;
import java.util.Optional;
import com.example.SpringAPI.api.model.Product;

public interface CrackerstoreService {
    Optional<Product> getProduct(Long id);
    List<String> getProductsCategoryList();
    List<Product> getProductsByCategory(String category);
    List<String> getOffers();
}
