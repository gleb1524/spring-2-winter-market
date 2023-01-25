package ru.geekbrains.karaban.springWinterMarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.karaban.springWinterMarket.entities.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String token;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.token = token;
    }
}
