package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.springWinterMarket.dtos.ProductDto;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;
import ru.geekbrains.karaban.springWinterMarket.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAllProducts(){

        return productRepository.findAll().stream()
                .map(product -> new ProductDto(product.getId(),product.getTitle(), product.getPrice()))
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(Long id){

        return productRepository.findById(id)
                .map(product -> new ProductDto(product.getId(),product.getTitle(), product.getPrice()));
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
