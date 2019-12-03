package dev.maba.healthserver.controller;


import dev.maba.healthserver.model.User;
import dev.maba.healthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") Long userId){
        System.out.println("ha");
        return null;
    }
    @PostMapping("/create")
    public User createUser(@RequestBody  User user){
        return userRepository.save(user);
    }
    @PostMapping("/delete")
    public void deleteUser(@RequestBody User userInput){
        User user = userRepository.getUserById(userInput.getId());
        userRepository.delete(user);
    }
    @PostMapping("/update")
    public User updateUser(@RequestBody User userInput){
        return userRepository.save(userInput);
    }

    @GetMapping("   /ada")
    public void testEndpoint(){
        System.out.println("Testing Successful");

    }

}
