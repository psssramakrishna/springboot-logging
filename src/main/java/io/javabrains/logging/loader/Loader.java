package io.javabrains.logging.loader;

import io.javabrains.logging.model.Users;
import io.javabrains.logging.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {


    @Autowired
    UserJpaRepository usersRepository;

    @PostConstruct
    public void load() {
        List<Users> usersList = getList();
        usersRepository.saveAll(usersList);
    }

    public List<Users> getList() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("Ajay", "Tech",123));
        usersList.add(new Users("Jaga", "Tech",13));
        return usersList;
    }

}
