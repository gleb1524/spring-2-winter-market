package ru.geekbrains.winter.market.cart.converter;

import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.winter.market.api.CartItemDto;
import ru.geekbrains.winter.market.cart.model.CartItem;

@Component
public class CartItemConverter {
    public CartItemDto entityToDo(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setPrice(cartItem.getPrice());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setTitle(cartItem.getTitle());
        cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
        cartItemDto.setProductId(cartItem.getProductId());
        return cartItemDto;
    }
}
