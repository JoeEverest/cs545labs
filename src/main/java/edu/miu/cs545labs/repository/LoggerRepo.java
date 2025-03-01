package edu.miu.cs545labs.repository;

import edu.miu.cs545labs.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo  extends JpaRepository<Logger, Long> {
}
