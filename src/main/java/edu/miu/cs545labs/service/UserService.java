package edu.miu.cs545labs.service;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User createUser(User user);
    User updateUser(long id, User user);
    void deleteUser(long id);
    List<User> getUsersWithPosts();
    List<Post> getPostsByUserId(long id);
    List<Post> searchAuthorPosts(String search);
}
