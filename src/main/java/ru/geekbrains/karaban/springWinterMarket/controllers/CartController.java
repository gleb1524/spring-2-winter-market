package ru.geekbrains.karaban.springWinterMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.springWinterMarket.model.Cart;
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

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        cartService.deleteProduct(id);
    }

    @DeleteMapping
    public void clearCart() {
        cartService.clear();
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        cartService.deleteItem(itemId);
    }
}
