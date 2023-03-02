package ru.geekbrains.karaban.winter.market.api;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartDto {
    public CartDto() {
    }

    public CartDto(List<CartItemDto> items, int totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    private List<CartItemDto> items;
    private int totalPrice;

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
