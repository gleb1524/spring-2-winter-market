package ru.geekbrains.winter.market.cart.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.winter.market.api.CartDto;
import ru.geekbrains.winter.market.cart.converter.CartConverter;
import ru.geekbrains.winter.market.cart.services.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;


    @GetMapping
    public CartDto getCart(){
       return cartConverter.entityToDto(cartService.getCurrentCart());
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
