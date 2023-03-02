package ru.geekbrains.winter.market.cart.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.winter.market.api.CartDto;
import ru.geekbrains.winter.market.cart.model.Cart;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class CartConverter {
    private final CartItemConverter cartItemConverter;

    public CartDto entityToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setItems(cart.getItems().stream().map(cartItemConverter::entityToDo).collect(Collectors.toList()));
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }
}
