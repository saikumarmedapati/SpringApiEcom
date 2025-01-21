package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.ProductEntity;
import com.sconexsoft.ecom.model.Product;
import com.sconexsoft.ecom.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(this::convertEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id).map(this::convertEntityToModel);
    }

    @Override
    public Product addProduct(Product product) {
        ProductEntity entity = convertModelToEntity(product);
        ProductEntity savedEntity = productRepo.save(entity);
        return convertEntityToModel(savedEntity);
    }

    @Override
    public Product updateProduct(Product product) {
        ProductEntity entity = convertModelToEntity(product);
        ProductEntity updatedEntity = productRepo.save(entity);
        return convertEntityToModel(updatedEntity);
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Convert ProductEntity to Product
    private Product convertEntityToModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setCategory(productEntity.getCategory());
        product.setBrand(productEntity.getBrand());
        product.setPrice(productEntity.getPrice());
        product.setBox(productEntity.getBox());
        product.setQuantity(productEntity.getQuantity());
        product.setTotal(productEntity.getTotal());
        product.setDiscount(productEntity.getDiscount());
        return product;
    }

    // Convert Product to ProductEntity
    private ProductEntity convertModelToEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setCategory(product.getCategory());
        productEntity.setBrand(product.getBrand());
        productEntity.setPrice(product.getPrice());
        productEntity.setBox(product.getBox());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setTotal(product.getTotal());
        productEntity.setDiscount(product.getDiscount());
        return productEntity;
    }
}
