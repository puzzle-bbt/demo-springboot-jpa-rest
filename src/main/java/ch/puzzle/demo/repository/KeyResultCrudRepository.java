package ch.puzzle.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import ch.puzzle.demo.model.database.KeyResult;

@Repository
public interface KeyResultCrudRepository extends CrudRepository<KeyResult, Long> {
    List<KeyResult> findByTitle(@Param("title") String title);
}
