package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.springWinterMarket.dtos.Cart;
import ru.geekbrains.karaban.springWinterMarket.dtos.ProductDto;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;
import ru.geekbrains.karaban.springWinterMarket.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartService {

    private  Cart tempCart;
    private final ProductService productService;
    public Cart getCurrentCart(){
        return tempCart;
    }

    @PostConstruct
    public void init() {
       tempCart = new Cart();
    }

    public void addProduct(Long id) {
         tempCart.addProduct(findProductById(id));
    }

    public void deleteProduct(Long id){
        tempCart.delete(id);
    }

    public void deleteAllProducts() {
        tempCart.deleteAll();
    }

    public void deleteItem(Long itemId) {
        tempCart.deleteItem(itemId);
    }

    private Product findProductById(Long id) {
         return (productService.findById(id).map(productDto ->
                new Product(productDto.getId(),productDto.getTitle(),productDto.getPrice(), LocalDateTime.now(), LocalDateTime.now())))
                .orElseThrow(() ->new ResourceNotFoundException("Корзина! Продукт не найден, id: " + id));
    }
}
