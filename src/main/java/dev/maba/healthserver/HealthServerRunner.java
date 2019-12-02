package dev.maba.healthserver;

import dev.maba.healthserver.repository.UserRepository;
import dev.maba.healthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthServerRunner {

    @Autowired
    UserService userService;


    public void run() {
        System.out.println("HSR");
        userService.createUser("AAA", "BBb");

    }
}
