package edu.miu.cs545labs.controller;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public List<Post> getAllPosts(@RequestParam(required = false) String author, @RequestParam(required = false) String authorSearch) {
        if (author != null) {
            return postService.getPostsByAuthor(author);
        }
        if(authorSearch != null) {
            return postService.searchAuthorPosts(authorSearch);
        }
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @PostMapping()
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
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
