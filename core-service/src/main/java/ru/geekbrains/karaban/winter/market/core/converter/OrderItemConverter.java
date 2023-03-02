package ru.geekbrains.karaban.winter.market.core.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.winter.market.api.OrderItemDto;
import ru.geekbrains.karaban.winter.market.core.entities.Order;
import ru.geekbrains.karaban.winter.market.core.entities.OrderItem;
import ru.geekbrains.karaban.winter.market.core.integrations.CartServiceIntegration;
import ru.geekbrains.karaban.winter.market.core.services.ProductService;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderItemConverter {

    private final CartServiceIntegration cartServiceIntegration;
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

//    public void modelToEntity (CartItem cartItem){
//        OrderItem orderItem = new OrderItem();
//        orderItem.setQuantity(cartItem.getQuantity());
//        orderItem.setPricePerProduct(cartItem.getPricePerProduct());
//        orderItem.setPrice(cartItem.getPrice());
//    }

    public List<OrderItem> orderToOrderItems(Order order) {
        OrderItem orderItem = new OrderItem();
       return cartServiceIntegration.getCurrentCart().getItems().stream().map(cartItem -> new OrderItem(orderItem.getId(),
                productService.findProductById(cartItem.getProductId()),
                order,
                cartItem.getQuantity(),
                cartItem.getPricePerProduct(),
                cartItem.getPrice(),
                LocalDateTime.now(),
                LocalDateTime.now())).collect(Collectors.toList());
    }
}
