package io.javabrains.logging.cache;

import io.javabrains.logging.model.Users;
import io.javabrains.logging.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsersCache {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name) {
        log.info("Retrieving from the Data Base for name: "+name);
        return userJpaRepository.findByName(name);
    }
}
