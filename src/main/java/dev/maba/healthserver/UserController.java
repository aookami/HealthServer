package dev.maba.healthserver;


import dev.maba.healthserver.model.User;
import dev.maba.healthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/create/{token}/{email}/{password}")
    public void createUser(@PathVariable(value = "token") String token, @PathVariable(value = "email") String email,
                        @PathVariable(value = "password") String password){
        System.out.println(token + email + password);
        userRepository.createUser(email, password);

    }


    @GetMapping("   /ada")
    public User getUser2(){
        System.out.println("ha");
        return null;

    }

}
