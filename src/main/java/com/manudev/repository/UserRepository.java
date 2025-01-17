package com.manudev.repository;

import com.manudev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT o FROM Order o WHERE o.active = true")
    List<User> findAllActiveOrders();
}
