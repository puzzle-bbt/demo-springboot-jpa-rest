package ch.puzzle.demo.repository.result;

import ch.puzzle.demo.model.database.results.PercentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentResultRepository extends JpaRepository<PercentResult, Long> {
}