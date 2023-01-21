package ru.geekbrains.karaban.springWinterMarket.dtos;

import lombok.Data;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalCoast;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }


    public void addProduct(Product product) {
        items.stream().filter(cartItem -> cartItem.getProductId().equals(product.getId()))
                .findFirst()
                .ifPresentOrElse(cartItem -> {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItem.setPriceTotal(cartItem.getPriceUnit() * cartItem.getQuantity());
                }, () -> {
                    items.add(new CartItem(product.getId(),
                            product.getTitle(), 1, product.getPrice(), product.getPrice(), items.size()));
                });

        recalculate();
    }

    public void delete(Long id) {
        items.stream().filter(cartItem -> cartItem.getProductId().equals(id))
                .findFirst().ifPresent(cartItem -> {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                    cartItem.setPriceTotal(cartItem.getPriceUnit() * cartItem.getQuantity());
                });
        recalculate();
    }

    public void deleteAll() {
        items = new ArrayList<>();
        recalculate();
    }

    public void deleteItem(Long itemId) {
        int id = Math.toIntExact(itemId);
        items.remove(id);
        recalculate();
    }

    private void recalculate() {
        totalCoast = 0;
        for (CartItem item : items) {
            totalCoast += item.getPriceTotal();
        }
    }
}
