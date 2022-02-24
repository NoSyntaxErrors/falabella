package com.falabella.store.dto;

import com.falabella.store.repository.entities.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ProductTest {


    @Test
    public void dtoTest(){
        getProductoDto().toString();
        getProducto().toString();
        getResponse().toString();
    }

    public static ProductDto getProductoDto(){
        return ProductDto.builder()
                .brand("Jeep")
                .image("https://falabella.scene7.com/is/image/Falabella/881952283_1")
                .sku("FAL-1111111")
                .name("Bicicleta")
                .price(125000.000)
                .size("L")
                .images(new ArrayList<>())
            .build();
    }

    public static Product getProducto(){
        return Product.builder()
                .brand("Jeep")
                .image("https://falabella.scene7.com/is/image/Falabella/881952283_1")
                .sku("FAL-1111111")
                .name("Bicicleta")
                .price(125000.000)
                .size("L")
                .images(new ArrayList<>())
            .build();
    }

    public static Response getResponse(){
        return Response.builder()
                .response(getProducto())
                .message("Esto es un Test")
            .build();
    }
}
