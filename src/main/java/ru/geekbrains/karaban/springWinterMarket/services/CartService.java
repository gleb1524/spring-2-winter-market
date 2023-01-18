package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.springWinterMarket.dtos.Cart;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {

    private  Cart cart;
    private final ProductService productService;
    public Cart getCurrentCart(){
        return cart;
    }

    @PostConstruct
    public void init() {
       cart = new Cart();
    }

    public void addProduct(Long id) {
        Product product = productService.findById(id).get();
        cart.addProduct(product);
    }
}
