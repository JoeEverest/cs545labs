package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

}
