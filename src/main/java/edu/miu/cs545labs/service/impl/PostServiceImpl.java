package edu.miu.cs545labs.service.impl;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.repository.PostRepo;
import edu.miu.cs545labs.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Post updatePost(long id, Post post) {
        Post existingPost = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postRepo.save(existingPost);
    }

    @Override
    @Transactional
    public void deletePost(long id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
        } else {
            throw new RuntimeException("Post not found");
        }
    }
}
