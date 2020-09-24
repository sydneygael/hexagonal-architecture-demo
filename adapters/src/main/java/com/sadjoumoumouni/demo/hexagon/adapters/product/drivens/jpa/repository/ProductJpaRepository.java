package com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository;

import com.sadjoumoumouni.demo.hexagon.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
