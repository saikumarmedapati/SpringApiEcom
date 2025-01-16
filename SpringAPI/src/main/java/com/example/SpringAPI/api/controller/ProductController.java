package com.example.SpringAPI.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringAPI.api.model.Product;
import com.example.SpringAPI.service.ProductService;

@RestController
public class ProductController {

	private ProductService productservice;

	@Autowired
	public ProductController(ProductService productservice) {
		this.productservice = productservice;
	}

	@GetMapping("/product")
	public Product getProduct(@RequestParam Integer id) {
		Optional product = productservice.getProduct(id);
		if (product.isPresent()) {
			return (Product) product.get();
		}
		return null;
	}

	// Endpoint to get the list of product categories
	
	@GetMapping("/productsCategoryList")
	public List<String> getProductsCategoryList() {
		return productservice.getProductsCategoryList();
	}

	// Endpoint to get products by category
	
	@GetMapping("/productsListGivenACategory")
	public List<Product> getProductsListGivenACategory(@RequestParam String category) {
		return productservice.getProductsByCategory(category);
	}
	
	// Endpoint to get the list of offers
	
    @GetMapping("/offersList")
    public List<String> getOffersList() {
        return productservice.getOffers();
    }

}
