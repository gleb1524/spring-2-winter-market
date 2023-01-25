package ru.geekbrains.karaban.springWinterMarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.entities.User;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

   Optional<List<Order>> findOrderByUserId(Long id);
}
