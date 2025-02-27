package edu.miu.cs545labs.service;

import edu.miu.cs545labs.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(long id);
    Post createPost(Post post);
    Post updatePost(long id, Post post);
    void deletePost(long id);
}
