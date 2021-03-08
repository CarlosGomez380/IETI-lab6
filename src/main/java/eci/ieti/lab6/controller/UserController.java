package eci.ieti.lab6.controller;

import eci.ieti.lab6.entity.User;
import eci.ieti.lab6.service.UserService;
import eci.ieti.lab6.service.UserServiceExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) throws  UserServiceExeption {
        return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserServiceExeption {
        return new ResponseEntity<>(userService.update(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(@PathVariable String userId) throws UserServiceExeption {
        userService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
