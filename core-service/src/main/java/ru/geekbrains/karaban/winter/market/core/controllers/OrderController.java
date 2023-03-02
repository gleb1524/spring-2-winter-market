package ru.geekbrains.karaban.winter.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.karaban.winter.market.api.OrderDto;
import ru.geekbrains.karaban.winter.market.api.UserDto;
import ru.geekbrains.karaban.winter.market.core.converter.UserConverter;
import ru.geekbrains.karaban.winter.market.core.services.OrderService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("*")
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
