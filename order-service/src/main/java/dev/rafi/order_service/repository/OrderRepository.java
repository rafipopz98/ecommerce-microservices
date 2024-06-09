package dev.rafi.order_service.repository;

import dev.rafi.order_service.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel,Long> {
}
