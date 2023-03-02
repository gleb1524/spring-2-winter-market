package ru.geekbrains.karaban.winter.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.karaban.winter.market.api.CartDto;
import ru.geekbrains.karaban.winter.market.api.ProductDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    public CartDto getCurrentCart() {
        return restTemplate.getForObject("http://localhost:8190/winter-carts/api/v1/cart", CartDto.class);
    }
}
