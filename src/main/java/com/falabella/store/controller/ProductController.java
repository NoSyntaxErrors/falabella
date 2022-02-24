package com.falabella.store.controller;

import com.falabella.store.dto.ProductDto;
import com.falabella.store.dto.Response;
import com.falabella.store.repository.entities.Product;
import com.falabella.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Response> addProduct(@Valid @RequestBody ProductDto product){

        Product productRes = productService.addProduct(product);
        Response response;

        if(productRes !=null){
            response = Response.builder()
                .response(productRes)
                .message(String.format("Product inserted correctly with SKU %s", productRes.getSku()))
                .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }else {
            response = Response.builder()
                .response(null)
                .message("Product was not inserted, please check parameters")
                .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{sku}")
    public ResponseEntity<Response> getProductBySKU(@PathVariable("sku") String sku){

        Product productRes = productService.getProductBySKU(sku);
        Response response;

        if(productRes ==null){
            response = Response.builder()
                .response(null)
                .message(String.format("Product with SKU %s does not exist.", sku))
                .build();
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

        }else {
             response = Response.builder()
                .response(productRes)
                .message(String.format("Product with SKU %s correctly consulted.", productRes.getSku()))
                .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{sku}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@PathVariable("sku") String sku, @Validated(ProductDto.ValidationAlways.class) @RequestBody ProductDto product){

        Product productRes = productService.updateProduct(sku, product);
        Response response;

        if(productRes==null){
            response = Response.builder()
                    .message("Product was not updated, please check parameters")
                    .response(null)
                .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else{
            response = Response.builder()
                    .message("Product updated correctly")
                    .response(productRes)
                .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("sku") String sku){

        Product productRes = productService.deleteProduct(sku);
        Response response;

        if(productRes ==null){
            response = Response.builder()
                .response(null)
                .message(String.format("Product with SKU %s does not exist.", sku))
            .build();

            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

        }else {
            response = Response.builder()
                .message(String.format("Product with SKU %s was successfully removed", sku))
                .response(productRes)
            .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
}
