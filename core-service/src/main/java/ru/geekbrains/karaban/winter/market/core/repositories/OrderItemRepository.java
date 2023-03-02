package ru.geekbrains.karaban.winter.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.winter.market.core.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
