package ru.geekbrains.karaban.springWinterMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;
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
        return productService.findById(id).get();
    }

}
