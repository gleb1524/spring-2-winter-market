package ru.geekbrains.karaban.springWinterMarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.entities.OrderItem;
import ru.geekbrains.karaban.springWinterMarket.entities.Product;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;

    private Long productId;

    private Long orderId;

    private int quantity;

    private int pricePerProduct;

    private int price;

//    public OrderItemDto(OrderItem orderItem) {
//        this.id = orderItem.getId();
//        this.productId = orderItem.getProduct().getId();
//        this.orderId = orderItem.getOrder().getId();
//        this.quantity = orderItem.getQuantity();
//        this.pricePerProduct = orderItem.getPricePerProduct();
//        this.price = orderItem.getPrice();
//    }
}
