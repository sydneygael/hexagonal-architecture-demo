package com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Long> {
}
