package com.falabella.store.controller;

import com.falabella.store.dto.ProductDto;
import com.falabella.store.dto.ProductTest;
import com.falabella.store.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductService productService;


    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void saveProductNullResponseTest(){
        controller.addProduct(ProductTest.getProductoDto());
    }

    @Test
    public void saveProductTest(){
        Mockito.when( productService.addProduct(Mockito.any(ProductDto.class))).thenReturn(ProductTest.getProducto());
        controller.addProduct(ProductTest.getProductoDto());
    }

    @Test
    public void updateProductNullResponseTest(){
        controller.updateProduct("FAL-1111111", ProductTest.getProductoDto());
    }

    @Test
    public void updateProductTest(){
        Mockito.when( productService.updateProduct(Mockito.anyString(), Mockito.any(ProductDto.class))).thenReturn(ProductTest.getProducto());
        controller.updateProduct("FAL-1111111", ProductTest.getProductoDto());
    }

    @Test
    public void getAllProductTest(){
        controller.getAllProducts();
    }

    @Test
    public void getBySkuProductNullResponseTest(){
        controller.getProductBySKU("FAL-1111111");

    }

    @Test
    public void getBySkuProductTest(){
        Mockito.when( productService.getProductBySKU(Mockito.anyString())).thenReturn(ProductTest.getProducto());
        controller.getProductBySKU("FAL-1111111");
    }

    @Test
    public void deleteProductNullResponseTest(){
        controller.deleteProduct("FAL-1111111");
    }

    @Test
    public void deleteProductTest(){
        Mockito.when( productService.deleteProduct(Mockito.anyString())).thenReturn(ProductTest.getProducto());
        controller.deleteProduct("FAL-1111111");
    }
}
