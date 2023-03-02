package ru.geekbrains.karaban.winter.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.winter.market.api.ProductDto;
import ru.geekbrains.karaban.winter.market.core.converter.ProductConverter;
import ru.geekbrains.karaban.winter.market.core.entities.Product;
import ru.geekbrains.karaban.winter.market.core.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public List<ProductDto> findAllProducts(){
        return productRepository.findAll().stream()
                .map(productConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(Long id){
        return productRepository.findById(id).map(productConverter::entityToDto);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
        );
    }
}
