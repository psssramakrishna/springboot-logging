package io.javabrains.logging.resource;

import io.javabrains.logging.cache.UsersCache;
import io.javabrains.logging.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/search")
public class UsersResource {

    @Autowired
    UsersCache usersCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable final String name){
        return usersCache.getUser(name);
    }
}
