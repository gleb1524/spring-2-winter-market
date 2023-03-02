package ru.geekbrains.karaban.winter.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.winter.market.core.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

   Optional<List<Order>> findOrderByUserId(Long id);
}
