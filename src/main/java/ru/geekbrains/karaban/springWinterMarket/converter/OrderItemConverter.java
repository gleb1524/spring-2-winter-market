package ru.geekbrains.karaban.springWinterMarket.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.springWinterMarket.dtos.OrderItemDto;
import ru.geekbrains.karaban.springWinterMarket.entities.Order;
import ru.geekbrains.karaban.springWinterMarket.entities.OrderItem;
import ru.geekbrains.karaban.springWinterMarket.model.CartItem;
import ru.geekbrains.karaban.springWinterMarket.services.CartService;
import ru.geekbrains.karaban.springWinterMarket.services.ProductService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderItemConverter {

    private final CartService cartService;
    private final ProductService productService;

    public OrderItemDto entityToDto (OrderItem orderItem){
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getProduct().getId(),
                orderItem.getOrder().getId(),
                orderItem.getQuantity(),
                orderItem.getPricePerProduct(),
                orderItem.getPrice());
    }

    public void modelToEntity (CartItem cartItem){
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setPricePerProduct(cartItem.getPricePerProduct());
        orderItem.setPrice(cartItem.getPrice());
    }

    public List<OrderItem> orderToOrderItems(Order order) {
        OrderItem orderItem = new OrderItem();
       return cartService.getCurrentCart().getItems().stream().map(cartItem -> new OrderItem(orderItem.getId(),
                productService.findProductById(cartItem.getProductId()),
                order,
                cartItem.getQuantity(),
                cartItem.getPricePerProduct(),
                cartItem.getPrice(),
                LocalDateTime.now(),
                LocalDateTime.now())).collect(Collectors.toList());
    }
}
