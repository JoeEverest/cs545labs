package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();
    Post findById(long id);
    List<Post> findByAuthor(String author);
    List<Post> searchAuthor(String search);
    void save(Post post);
    Post update(long id, Post post);
    void delete(long id);
}
