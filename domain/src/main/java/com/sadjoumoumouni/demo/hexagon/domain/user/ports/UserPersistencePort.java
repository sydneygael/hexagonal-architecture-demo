package com.sadjoumoumouni.demo.hexagon.domain.user.ports;

import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;

public interface UserPersistencePort {

    User addNewUser(User user);

    User updateUserInfos(User user);

}
