package com.falabella.store.service;

import com.falabella.store.dto.ProductDto;
import com.falabella.store.dto.ProductTest;
import com.falabella.store.repository.ProductRepository;
import com.falabella.store.repository.entities.Product;
import com.falabella.store.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl service;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void addProductTest(){
        service.addProduct(ProductTest.getProductoDto());
    }

    @Test
    public void getProductBySKUTest(){
        service.getProductBySKU("");
    }

    @Test
    public void getAllProducts(){
        service.getAllProducts();
    }

    @Test
    public void updateProduct(){
        Mockito.when(productRepository.getProductBySKU(Mockito.any())).thenReturn(ProductTest.getProducto());
        service.updateProduct("", ProductTest.getProductoDto());
    }

    @Test
    public void deleteProduct(){
        service.deleteProduct("");
    }
}
