package ru.geekbrains.karaban.springWinterMarket.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.karaban.springWinterMarket.dtos.UserDto;
import ru.geekbrains.karaban.springWinterMarket.exceptions.ResourceNotFoundException;
import ru.geekbrains.karaban.springWinterMarket.services.UserService;

import java.security.Principal;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final UserService userService;
    public UserDto principalToUser(Principal principal) {
        return new UserDto(userService.findByUsername(principal.getName())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден")));

    }
}
