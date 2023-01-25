package ru.geekbrains.karaban.springWinterMarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderData {
    private String address;
    private String phone;

}
