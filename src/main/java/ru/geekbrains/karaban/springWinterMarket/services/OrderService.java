package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.karaban.springWinterMarket.converter.OrderConverter;
import ru.geekbrains.karaban.springWinterMarket.dtos.OrderDto;
import ru.geekbrains.karaban.springWinterMarket.dtos.UserDto;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.exceptions.ResourceNotFoundException;
import ru.geekbrains.karaban.springWinterMarket.repositories.OrderRepository;


import java.util.List;
import java.util.stream.Collectors;


@Data
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderItemService orderItemService;
    private final UserService userService;
    private final OrderConverter orderConverter;

    @Transactional
    public void createOrder(UserDto userDto) {
        Order order = new Order();
        order.setTotalPrice(cartService.getCurrentCart().getTotalPrice());
        order.setUser(userService
                .findByUsername(userDto.getUsername())
                .orElseThrow(()-> new ResourceNotFoundException("Невозможно добавить заказ. Пользователь не найден.")));
        orderRepository.save(order);
        orderItemService.creatOrderItem(order);
    }

    public List<OrderDto> findOrdersByUserId(Long id) {
        return orderRepository.findOrderByUserId(id).orElseThrow(()->new ResourceNotFoundException("Заказы пользователя с айди: " + "не найдены"))
                .stream()
                .map(orderConverter::entityToDto)
                .collect(Collectors.toList());
    }

}
