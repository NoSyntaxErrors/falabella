package com.falabella.store.service;

import com.falabella.store.dto.ProductDto;
import com.falabella.store.repository.entities.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductDto product);

    Product getProductBySKU(String sku);

    List<Product> getAllProducts();

    Product updateProduct(String sku, ProductDto product);

    Product deleteProduct(String sku);
}
