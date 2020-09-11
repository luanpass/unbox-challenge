package br.com.unbox.controller;

import br.com.unbox.data.UserData;
import br.com.unbox.register.UserRegister;
import br.com.unbox.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserValidator userValidator;
    private final UserRegister userRegister;

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> createUser(@RequestBody UserData userData, BindingResult bindingResult) {

        userValidator.validate(userData, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.toString());
        }
        userRegister.saveUser(userData);
        return ResponseEntity.ok(userData);
    }

}
