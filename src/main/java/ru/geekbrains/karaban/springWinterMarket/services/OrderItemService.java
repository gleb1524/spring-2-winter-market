package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.springWinterMarket.converter.OrderItemConverter;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.entities.OrderItem;
import ru.geekbrains.karaban.springWinterMarket.repositories.OrderItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemConverter orderItemConverter;


    public void creatOrderItem(Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        List<OrderItem> orderItems = orderItemConverter.orderToOrderItems(order);
        orderItemRepository.saveAll(orderItems);
    }

}
