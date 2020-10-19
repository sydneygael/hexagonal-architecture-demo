package com.sadjoumoumouni.demo.hexagon.core.user.usecase;

import java.util.List;
import java.util.Optional;

import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;

public interface GetUsers {

    List<User> getAllUsers();
    Optional<User> getUserById(String userId);
}
