package ru.geekbrains.winter.market.cart.model;

import lombok.Data;
import ru.geekbrains.karaban.winter.market.api.ProductDto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }


    public void addProduct(ProductDto product) {
        items.stream().filter(cartItem -> cartItem.getProductId().equals(product.getId()))
                .findFirst()
                .ifPresentOrElse(cartItem -> {
                    cartItem.resetQuantity(1);
                }, () -> {
                    items.add(new CartItem(product.getId(),
                            product.getTitle(), 1, product.getPrice(), product.getPrice()));
                });

        recalculate();
    }

    public void delete(Long id) {
        items.stream().filter(cartItem -> cartItem.getProductId().equals(id))
                .findFirst().ifPresent(cartItem -> {
                    if(cartItem.getQuantity() == 1){
                        deleteItem(id);
                    } else {
                        cartItem.resetQuantity(-1);
                        recalculate();
                    }
                });
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void deleteItem(Long itemId) {
        if (items.removeIf(item -> item.getProductId().equals(itemId))) {
            recalculate();
        }
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }
}
