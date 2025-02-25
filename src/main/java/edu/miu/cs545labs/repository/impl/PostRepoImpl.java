package edu.miu.cs545labs.repository.impl;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.repository.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

    List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.stream().filter(post -> post.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    @Override
    public List<Post> searchAuthor(String search) {
        return posts.stream().filter(post -> post.getAuthor().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public void save(Post post) {
        posts.add(post);
    }

    @Override
    public Post update(long id, Post post) {
        var thePost = findById(id);
        thePost.setTitle(post.getTitle());
        thePost.setContent(post.getContent());
        thePost.setAuthor(post.getAuthor());
        return thePost;
    }

    @Override
    public void delete(long id) {
        posts.removeIf(post -> post.getId() == id);
    }


}
