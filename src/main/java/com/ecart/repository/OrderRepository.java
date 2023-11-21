package com.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.repository.models.OrderEntity;

/**
 * Order repository
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	public List<OrderEntity> getOrdersByCustomerId(Long customerId );
}