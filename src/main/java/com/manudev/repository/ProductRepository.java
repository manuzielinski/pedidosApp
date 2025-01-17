package com.manudev.repository;

import com.manudev.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT o FROM Order o WHERE o.active = true")
    List<Product> findAllActiveOrders();
}
