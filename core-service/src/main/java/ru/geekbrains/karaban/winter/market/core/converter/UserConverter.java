package ru.geekbrains.karaban.winter.market.core.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.winter.market.api.ResourceNotFoundException;
import ru.geekbrains.karaban.winter.market.api.UserDto;
import ru.geekbrains.karaban.winter.market.core.entities.User;
import ru.geekbrains.karaban.winter.market.core.services.UserService;

import java.security.Principal;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final UserService userService;
    public UserDto principalToUser(Principal principal) {
        UserDto userDto = new UserDto();
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        return userDto;

    }
}
