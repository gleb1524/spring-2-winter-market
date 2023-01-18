package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;
import ru.geekbrains.karaban.springWinterMarket.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

}
