package ru.geekbrains.karaban.winter.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.winter.market.core.converter.OrderItemConverter;
import ru.geekbrains.karaban.winter.market.core.entities.Order;
import ru.geekbrains.karaban.winter.market.core.entities.OrderItem;
import ru.geekbrains.karaban.winter.market.core.repositories.OrderItemRepository;

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
