package com.lmar.mybatis.controller;

import com.lmar.mybatis.exception.UserIdAlreadyExistException;
import com.lmar.mybatis.exception.UserIdNotFoundException;
import com.lmar.mybatis.model.User;
import com.lmar.mybatis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        if(userRepository.findById(user.getId()) == null) {
            int status = userRepository.insert(user);
            return userRepository.findById(user.getId());
        } else {
            throw new UserIdAlreadyExistException();
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id);
        if(user==null)
        {
            throw new UserIdNotFoundException();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        if(userRepository.update(
                new User(
                        id,
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getEmail(),
                        userDetails.getPassword())
        ) == 0) {
            throw new UserIdNotFoundException();
        }

        return ResponseEntity.ok(userRepository.findById(id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
