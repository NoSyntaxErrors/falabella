package com.falabella.store.service.impl;

import com.falabella.store.dto.ProductDto;
import com.falabella.store.repository.ProductRepository;
import com.falabella.store.repository.entities.Product;
import com.falabella.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product addProduct(ProductDto product) {

        Product prod = Product.builder()
                .sku(product.getSku())
                .brand(product.getBrand())
                .image(product.getImage())
                .images(product.getImages())
                .price(product.getPrice())
                .name(product.getName())
                .size(product.getSize())
                .build();

        return  productRepository.saveAndFlush(prod);
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.getProductBySKU(sku);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(String sku, ProductDto product) {
        Product prod = getProductBySKU(sku);

        prod.setBrand(product.getBrand());
        prod.setImage(product.getImage());
        prod.setPrice(product.getPrice());
        prod.setName(product.getName());
        prod.setSize(product.getSize());
        prod.setImages(product.getImages());

        return productRepository.save(prod);
    }

    @Override
    public Product deleteProduct(String sku) {
        Product prod = productRepository.getProductBySKU(sku);

        productRepository.delete(prod);
        return prod;
    }
}
