package com.falabella.store.repository;

import com.falabella.store.repository.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query(value = "SELECT p FROM product p WHERE p.sku = :sku")
    Product getProductBySKU(@Param("sku") String sku);


}
