package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringAPI.api.model.Product;

@Repository
public interface CrackerStoreRepository extends JpaRepository<Product, Long> {
}
