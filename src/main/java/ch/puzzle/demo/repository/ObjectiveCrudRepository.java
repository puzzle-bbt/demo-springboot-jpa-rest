package ch.puzzle.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import ch.puzzle.demo.model.database.Objective;

@Repository
public interface ObjectiveCrudRepository extends CrudRepository<Objective, Long> {
    List<Objective> findByTitle(@Param("title") String title);

}
