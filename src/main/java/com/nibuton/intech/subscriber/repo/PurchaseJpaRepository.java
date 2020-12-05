package com.nibuton.intech.subscriber.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.intech.subscriber.entity.Purchase;

public interface PurchaseJpaRepository extends JpaRepository<Purchase, Integer> {
}
