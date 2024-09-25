package test.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.backend.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
