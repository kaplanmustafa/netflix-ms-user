package com.clone.netflix.msuser.api.controllers;

import com.clone.netflix.msuser.business.abstracts.UserService;
import com.clone.netflix.msuser.core.results.Result;
import com.clone.netflix.msuser.entities.dtos.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result addUser(@Valid @RequestBody AddUserDto addUserDto) {
        return userService.addUser(addUserDto);
    }
}
