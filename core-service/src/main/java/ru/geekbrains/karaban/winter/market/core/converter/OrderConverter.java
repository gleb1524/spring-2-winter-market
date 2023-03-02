package ru.geekbrains.karaban.winter.market.core.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.winter.market.api.OrderDto;
import ru.geekbrains.karaban.winter.market.core.entities.Order;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final OrderItemConverter orderItemConverter;
    public OrderDto entityToDto (Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setPhone(orderDto.getPhone());
        orderDto.setAddress(order.getAddress());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setOrderItemDtos(order.getOrderItems()
                        .stream()
                        .map(orderItemConverter::entityToDto).collect(Collectors.toList()));
        return orderDto;
    }
}
