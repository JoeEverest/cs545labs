package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Post;
import edu.miu.cs545labs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, Long> {
}
