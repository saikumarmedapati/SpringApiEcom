package com.example.SpringAPI.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringAPI.api.model.Product;

@Service
public class ProductService {

	private List<Product> productList;

	public ProductService() {
		productList = new ArrayList<>();

		Product p1 = new Product(1, "Ground Chakkar - Big -10 pcs", "GROUND CHAKKAR", "AGNIE", 24, 350);
		Product p2 = new Product(2, "Ground Chakkar - Big -25 pcs", "GROUND CHAKKAR", "GIRIJA", 30, 400);
		Product p3 = new Product(3, "Ground Chakkar - Special", "GROUND CHAKKAR", "GIRIJA", 34, 230);
		Product p4 = new Product(4, "Ground Chakkar - Special", "GROUND CHAKKAR", "AGNIE", 45, 250);
		Product p5 = new Product(5, "Ground Chakkar - Ashoka", "GROUND CHAKKAR", "STD", 54, 120);

		productList.addAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// Adding new products from BOMBS category
        Product p6 = new Product(69, "2 3/4 pitta bomb - NET", "BOMBS", "AGNIE", 4, 1500);
        Product p7 = new Product(70, "4\" Lakshmi Bomb", "BOMBS", "AGNIE", 10, 500);
        Product p8 = new Product(71, "King of King bomb", "BOMBS", "AGNIE", 46, 250);
        Product p9 = new Product(72, "Mega Flash 5 Ply Green", "BOMBS", "AGNIE", 64, 170);
        Product p10 = new Product(73, "Thunder Bomb - Green", "BOMBS", "STD", 80, 120);
        
        productList.addAll(Arrays.asList(p6,p7,p8,p9,p10));
	}

	public Optional<Product> getProduct(Integer id) {
		Optional optional = Optional.empty();
		for (Product product : productList) {
			if (id == product.getId()) {
				optional = Optional.of(product);
				return optional;
			}
		}
		return optional;
	}

	// Method to get a list of product categories
	public List<String> getProductsCategoryList() {
		return productList.stream().map(Product::getCategory) // Assuming getCategory() returns the category of the
																// product
				.distinct().collect(Collectors.toList());
	}

	// Method to get products by category
	public List<Product> getProductsByCategory(String category) {
	    return productList.stream()
	            .filter(product -> category.equals(product.getCategory()))
	            .collect(Collectors.toList());
	}

	// Method to get a list of offers (assuming offers are based on some criteria)
	public List<String> getOffers() {
		return productList.stream().filter(product -> product.getPrice() < 300) // Example condition for offers
				.map(Product::getName) // Assuming getName() returns the product name
				.collect(Collectors.toList());
	}
}
