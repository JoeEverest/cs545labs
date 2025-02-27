package edu.miu.cs545labs.controller;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;
import edu.miu.cs545labs.service.PostService;
import edu.miu.cs545labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @PostMapping()
    public User addPost(@RequestParam() long userId, @RequestBody Post post) {
        User user = userService.getUserById(userId);
        System.out.println("User: " + user);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.getPosts().add(post);
        return userService.updateUser(userId, user);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }
}
