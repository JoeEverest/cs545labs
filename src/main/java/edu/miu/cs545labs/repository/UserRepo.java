package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo  extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.posts WHERE u.posts IS NOT EMPTY")
    List<User> findUsersWithPosts();

    @Query("SELECT u FROM User u JOIN FETCH u.posts WHERE SIZE(u.posts) > ?1")
    List<User> findUsersWithMoreThanNPosts(int n);

    @Query("SELECT u.posts FROM User u WHERE u.name = ?1")
    List<Post> findPostsByAuthorName(String name);

    @Query("SELECT u.posts FROM User u WHERE u.id = ?1")
    List<Post> findPostsByAuthorId(long id);
}
