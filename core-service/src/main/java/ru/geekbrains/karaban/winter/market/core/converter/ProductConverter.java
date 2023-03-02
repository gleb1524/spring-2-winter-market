package ru.geekbrains.karaban.winter.market.core.converter;

import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.winter.market.core.entities.Product;
import ru.geekbrains.karaban.winter.market.api.ProductDto;

@Component
public class ProductConverter {

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

}
