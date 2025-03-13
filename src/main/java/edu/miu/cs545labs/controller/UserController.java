package edu.miu.cs545labs.controller;

import edu.miu.cs545labs.annotations.ExecutionTime;
import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;
import edu.miu.cs545labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/posts")
    public List<User> getUsersWithPosts(@RequestParam(required = false) int count) {
        if (count != 0) {
            return userService.getUsersWithMoreThanNPosts(count);
        }
        return userService.getUsersWithPosts();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable long id) {
        return userService.getPostsByUserId(id);
    }

    @GetMapping("/search")
    public List<Post> searchAuthorPosts(@RequestParam String search) {
        return userService.searchAuthorPosts(search);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
