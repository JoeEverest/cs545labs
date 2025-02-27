package edu.miu.cs545labs.controller;

import edu.miu.cs545labs.domain.Comment;
import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;
import edu.miu.cs545labs.service.CommentService;
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
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.getPosts().add(post);
        return userService.updateUser(userId, user);
    }

    @PostMapping("/{id}/comments")
    public Comment addComment(@PathVariable long id, @RequestBody Comment comment) {
        Post post = postService.getPostById(id);
        if (post == null) {
            throw new RuntimeException("Post not found");
        }
        post.getComments().add(comment);
        postService.updatePost(id, post);
        return comment;
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
