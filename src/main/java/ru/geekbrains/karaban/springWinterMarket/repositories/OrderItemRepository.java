package ru.geekbrains.karaban.springWinterMarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.springWinterMarket.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
