package ru.geekbrains.karaban.winter.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.karaban.winter.market.core.entities.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
}
