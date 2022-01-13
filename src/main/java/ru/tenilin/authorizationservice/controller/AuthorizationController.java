package ru.tenilin.authorizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tenilin.authorizationservice.service.Authorities;
import ru.tenilin.authorizationservice.service.AuthorizationService;
import ru.tenilin.authorizationservice.service.InvalidCredentials;
import ru.tenilin.authorizationservice.service.UnauthorizedUser;

import java.util.List;

@RestController
public class AuthorizationController {
    public AuthorizationService service;

    public AuthorizationController (AuthorizationService authorizationService) {
       this.service = authorizationService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials (InvalidCredentials e) {
        return e.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthorizedUser (UnauthorizedUser e) {
        return e.getMessage();
    }

}
