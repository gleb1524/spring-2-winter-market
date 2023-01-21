package ru.geekbrains.karaban.springWinterMarket.dtos;

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

    private int itemId;

}
