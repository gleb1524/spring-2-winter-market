package ru.geekbrains.karaban.springWinterMarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
}
