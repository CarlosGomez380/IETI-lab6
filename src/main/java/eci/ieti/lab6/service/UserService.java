package eci.ieti.lab6.service;

import eci.ieti.lab6.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();

    User getById(String userId) throws UserServiceExeption;

    User create(User user);

    User update(User user) throws UserServiceExeption;

    void remove(String userId) throws UserServiceExeption;
}