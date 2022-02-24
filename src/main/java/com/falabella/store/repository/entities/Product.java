package com.falabella.store.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "sku", unique = true)
    @Length(min = 11, max = 12)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKUGenerator")
   // @GenericGenerator(name = "SKUGenerator", strategy = "com.falabella.store.repository.entities.ProductSKUGenerator")
    private String sku;

    @Column(name = "name", length = 50)
    @Length(min = 3, max = 50)
    private String name;

    @Column(name = "brand")
    @Length(min = 3, max = 50)
    private String brand;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    @Range(min = 1 , max = 99999999)
    private Double price;

    @Column(name = "image")
    private String image;

    @Column(name= "images")
    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    private List<String> images;

}
