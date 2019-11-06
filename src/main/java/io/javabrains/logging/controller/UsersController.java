package io.javabrains.logging.controller;

import io.javabrains.logging.model.Users;
import io.javabrains.logging.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Users> findAll(){
       return userJpaRepository.findAll();
    }

    @GetMapping("/{name}")
    public Users findByName(@PathVariable final String name){
        return userJpaRepository.findByName(name);
    }

    @PostMapping("/load")
    public Users load(@RequestBody final Users users){
        userJpaRepository.save(users);
        return userJpaRepository.findByName(users.getName());
    }
}
