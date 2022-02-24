package com.falabella.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProductDto {

    @NotBlank(message = "SKU must not be blank")
    @Pattern(regexp = "FAL-\\w{7,8}")
    private String sku;

    @NotBlank(message = "Name must not be blank",groups = ValidationAlways.class)
    @Size(min = 3, max = 50, message = "Lenght of product name is invalid, please choose a name with length between 3 and 50.",groups = ValidationAlways.class)
    private String name;

    @NotBlank(message = "Brand must not be blank",groups = ValidationAlways.class)
    @Size(min = 3, max = 50, message = "Lenght of product brand is invalid, please choose a brand with length between 3 and 50.",groups = ValidationAlways.class)
    private String brand;

    @NotBlank(message = "Value for size of the product must not be blank",groups = ValidationAlways.class)
    private String size;

    @Range(min = 1, max = 99999999, message = "Value of product price is invalid, please choose a price valid between 1.00 and 99999999.00",groups = ValidationAlways.class)
    private Double price;

    @NotBlank(message = "Value for Image of the product must not be blank" ,groups = ValidationAlways.class)
    @URL(message = "URL of the product image is invalid, please choose a valid URL",groups = ValidationAlways.class)
    private String image;

    private List<String> images;

    public interface ValidationAlways {
    }
}
