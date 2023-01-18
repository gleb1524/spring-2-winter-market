package ru.geekbrains.karaban.springWinterMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.springWinterMarket.dtos.Cart;
import ru.geekbrains.karaban.springWinterMarket.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @GetMapping
    public Cart getCart(){
       return cartService.getCurrentCart();
    }

    @GetMapping("/add/{id}")
    public void addProduct(@PathVariable Long id){
        cartService.addProduct(id);
    }
}
