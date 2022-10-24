package ch.puzzle.demo.repository.result;

import ch.puzzle.demo.model.database.results.BooleanResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooleanResultRepository extends JpaRepository<BooleanResult, Long> {
}