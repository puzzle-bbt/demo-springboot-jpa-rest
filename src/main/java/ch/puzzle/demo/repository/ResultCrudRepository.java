package ch.puzzle.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ch.puzzle.demo.model.Result;

public interface ResultCrudRepository extends CrudRepository<Result, Long> {
    List<Result> findByName(@Param("name") String name);
}
