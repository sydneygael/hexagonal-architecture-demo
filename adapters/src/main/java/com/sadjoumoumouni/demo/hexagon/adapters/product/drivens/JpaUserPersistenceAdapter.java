package com.sadjoumoumouni.demo.hexagon.adapters.product.drivens;

import java.util.List;

import com.sadjoumoumouni.demo.hexagon.adapters.product.drivens.jpa.repository.UserJpaRepository;
import com.sadjoumoumouni.demo.hexagon.domain.product.exception.DoesNotExistException;
import com.sadjoumoumouni.demo.hexagon.domain.user.entity.User;
import com.sadjoumoumouni.demo.hexagon.domain.user.ports.UserPersistencePort;

public class JpaUserPersistenceAdapter implements UserPersistencePort {

    private final UserJpaRepository userJpaRepository;

    public JpaUserPersistenceAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User addNewUser(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public User updateUserInfos(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public boolean deleteUser(User user) throws DoesNotExistException {
        try {
            userJpaRepository.delete(user);
            return true;
        } catch (Exception e) {
            throw new DoesNotExistException(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }
}
