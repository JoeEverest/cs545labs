package edu.miu.cs545labs.service.impl;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.repository.PostRepo;
import edu.miu.cs545labs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return postRepo.findById(id);
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        return postRepo.findByAuthor(author);
    }

    @Override
    public List<Post> searchAuthorPosts(String search) {
        return postRepo.searchAuthor(search);
    }

    @Override
    public Post createPost(Post post) {
        var size = postRepo.findAll().size();
        Post newPost = new Post(size+1, post.getTitle(), post.getContent(), post.getAuthor());
        postRepo.save(newPost);
        return newPost;
    }

    @Override
    public Post updatePost(long id, Post post) {
        return postRepo.update(id, post);
    }

    @Override
    public void deletePost(long id) {
        postRepo.delete(id);
    }
}
