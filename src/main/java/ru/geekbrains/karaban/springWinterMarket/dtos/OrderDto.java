package ru.geekbrains.karaban.springWinterMarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;

    private List<OrderItemDto> orderItemDtos;

    private int totalPrice;

    private String address;

    private String phone;

//    public OrderDto(Order order) {
//        this.id = order.getId();
//        this.orderItemDtos = order.getOrderItems().stream()
//                .map(OrderItemDto::new)
//                .collect(Collectors.toList());
//        this.totalPrice = order.getTotalPrice();
//        this.address = order.getAddress();
//        this.phone = order.getPhone();
//    }
}
