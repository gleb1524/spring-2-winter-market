package ru.geekbrains.karaban.springWinterMarket.dtos;

import lombok.Data;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Data
public class Cart {
    private List<CartItem> items;
    private int totalCoast = 0;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }


    public void addProduct(Product product) {
        items.add(new CartItem(product.getId(),product.getTitle(), 1,product.getPrice(), product.getPrice()));
        recalculate();
    }

    private void recalculate() {
        totalCoast = 0;
        for(CartItem item : items) {
            totalCoast += item.getPriceUnit();
        }
    }

}
