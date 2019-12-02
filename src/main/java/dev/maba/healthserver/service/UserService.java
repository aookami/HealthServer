package dev.maba.healthserver.service;

import dev.maba.healthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(String email, String password) {
        System.out.println("AAsd");
        userRepository.createUser(email, password);
    }

}
