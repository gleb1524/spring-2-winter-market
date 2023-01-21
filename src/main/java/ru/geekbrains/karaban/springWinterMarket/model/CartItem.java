package ru.geekbrains.karaban.springWinterMarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {


    private Long productId;

    private String title;

    private int quantity;

    private int priceUnit;

    private int priceTotal;


    public void resetQuantity(int delta) {
        quantity += delta;
        priceTotal = priceUnit * quantity;
    }

}
