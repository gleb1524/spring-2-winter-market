package ru.geekbrains.karaban.springWinterMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.entities.OrderItem;
import ru.geekbrains.karaban.springWinterMarket.repositories.OrderItemRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final CartService cartService;
    private final ProductService productService;


    public void creatOrderItem(Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        List<OrderItem> orderItems = cartService.getCurrentCart().getItems().stream()
                .map(cartItem -> new OrderItem(orderItem.getId(),
                                                productService.findProductById(cartItem.getProductId()),
                                                order,
                                                cartItem.getQuantity(),
                        cartItem.getPricePerProduct(),
                        cartItem.getPrice(),
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )).collect(Collectors.toList());
        orderItemRepository.saveAll(orderItems);
    }

}
