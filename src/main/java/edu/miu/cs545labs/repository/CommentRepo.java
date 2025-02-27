package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo  extends JpaRepository<Comment, Long> {
}
