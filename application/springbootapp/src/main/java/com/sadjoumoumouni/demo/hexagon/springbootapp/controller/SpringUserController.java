package com.sadjoumoumouni.demo.hexagon.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadjoumoumouni.demo.hexagon.core.user.UserFacade;
import com.sadjoumoumouni.demo.hexagon.core.user.usecase.GetUsers;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;

@RestController
@RequestMapping("/api/user")
public class SpringUserController {

    private final GetUsers getUsers;

    @Autowired
    public SpringUserController(final UserFacade userFacade) {
        this.getUsers = userFacade;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return getUsers.getAllUsers();
    }
}
