package ru.geekbrains.karaban.springWinterMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;
import ru.geekbrains.karaban.springWinterMarket.exceptions.AppError;
import ru.geekbrains.karaban.springWinterMarket.exceptions.ResourceNotFoundException;
import ru.geekbrains.karaban.springWinterMarket.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: " + id));
    }

}
