package ru.geekbrains.karaban.springWinterMarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
