package ch.puzzle.demo.repository.result;

import ch.puzzle.demo.model.database.results.TextResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextResultRepository extends JpaRepository<TextResult, Integer> {
}
