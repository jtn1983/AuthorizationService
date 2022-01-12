package ru.tenilin.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.tenilin.authorizationservice.service.Authorities;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private final String USER = "admin";
    private final String PASSWORD = "123";

    public List<Authorities> getUserAuthorities(String user, String password) {
        return (user.equals(USER) && password.equals(PASSWORD)) ? Arrays.asList(Authorities.values()) : null;
    }
}
