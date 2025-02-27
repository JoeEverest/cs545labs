package edu.miu.cs545labs.service.impl;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;
import edu.miu.cs545labs.repository.UserRepo;
import edu.miu.cs545labs.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User updateUser(long id, User user) {
        if(!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<User> getUsersWithPosts() {
        return userRepo.findAll().stream().filter(user -> !user.getPosts().isEmpty()).toList();
    }

    @Override
    public List<User> getUsersWithMoreThanNPosts(int n) {
        return userRepo.findAll().stream().filter(user -> user.getPosts().size() > n).toList();
    }

    @Override
    public List<Post> getPostsByUserId(long id) {
        return userRepo.findById(id).map(User::getPosts).orElse(null);
    }

    @Override
    public List<Post> searchAuthorPosts(String search) {
        return userRepo.findAll().stream().filter(user -> user.getName().contains(search)).flatMap(user -> user.getPosts().stream()).toList();
    }
}
