package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.title = ?1")
    List<Post> findByTitle(String title);
}
