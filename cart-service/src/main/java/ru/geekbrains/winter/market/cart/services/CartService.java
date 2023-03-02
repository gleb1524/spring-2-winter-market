package ru.geekbrains.winter.market.cart.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.winter.market.api.ProductDto;
import ru.geekbrains.karaban.winter.market.api.ResourceNotFoundException;
import ru.geekbrains.winter.market.cart.integrations.ProductServiceIntegration;
import ru.geekbrains.winter.market.cart.model.Cart;


import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartService {

    private Cart tempCart;
    private final ProductServiceIntegration productServiceIntegration;

    public Cart getCurrentCart(){
        return tempCart;
    }

    @PostConstruct
    public void init() {
       tempCart = new Cart();
    }

    public void addProduct(Long id) {
        ProductDto productDto = productServiceIntegration.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти продукт с id " + id));
        tempCart.addProduct(productDto);
    }

    public void deleteProduct(Long id){
        tempCart.delete(id);
    }

    public void clear() {
        tempCart.clear();
    }

    public void deleteItem(Long itemId) {
        tempCart.deleteItem(itemId);
    }

}
