package ru.geekbrains.karaban.springWinterMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.springWinterMarket.converter.UserConverter;
import ru.geekbrains.karaban.springWinterMarket.dtos.OrderDto;
import ru.geekbrains.karaban.springWinterMarket.dtos.UserDto;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.entities.User;
import ru.geekbrains.karaban.springWinterMarket.exceptions.ResourceNotFoundException;
import ru.geekbrains.karaban.springWinterMarket.services.OrderService;
import ru.geekbrains.karaban.springWinterMarket.services.UserService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserConverter userConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal) {
        UserDto userDto = userConverter.principalToUser(principal);
        orderService.createOrder(userDto);
    }

    @GetMapping
    public List<OrderDto> findOrders(Principal principal) {
        UserDto userDto = userConverter.principalToUser(principal);
        return orderService.findOrdersByUserId(userDto.getId());
    }


}
