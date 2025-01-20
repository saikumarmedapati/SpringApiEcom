package com.example.SpringAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringAPI.api.model.Product;
import com.spring.repository.CrackerStoreRepository;

@Service
public class CrackerstoreServiceImpl implements CrackerstoreService {

    private final CrackerStoreRepository csr;

    public CrackerstoreServiceImpl(CrackerStoreRepository csr) {
        this.csr = csr;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return csr.findById(id);
    }

    @Override
    public List<String> getProductsCategoryList() {
        return csr.findAll()
                 .stream()
                 .map(Product::getCategory)
                 .distinct()
                 .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return csr.findAll()
                 .stream()
                 .filter(product -> category.equalsIgnoreCase(product.getCategory()))
                 .collect(Collectors.toList());
    }

    @Override
    public List<String> getOffers() {
        return csr.findAll()
                 .stream()
                 .filter(product -> product.getDiscount() > 0)
                 .map(product -> product.getName() + " - " + product.getDiscount() + "% off")
                 .collect(Collectors.toList());
    }
}
