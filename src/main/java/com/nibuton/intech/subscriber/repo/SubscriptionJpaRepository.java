package com.nibuton.intech.subscriber.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibuton.intech.subscriber.entity.Subscription;

public interface SubscriptionJpaRepository extends JpaRepository<Subscription, Integer>{
}
