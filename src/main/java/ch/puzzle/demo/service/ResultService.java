package ch.puzzle.demo.service;

import ch.puzzle.demo.model.database.KeyResult;
import ch.puzzle.demo.model.database.User;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import ch.puzzle.demo.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public abstract class ResultService {
    private final KeyResultCrudRepository keyResultCrudRepository;

    @Autowired
    protected ResultService(KeyResultCrudRepository keyResultCrudRepository) {
        this.keyResultCrudRepository = keyResultCrudRepository;
    }

    protected KeyResult findKeyResultWithId(Long keyResultId) {
        Optional<KeyResult> keyResultOptional = this.keyResultCrudRepository.findById(keyResultId);
        return keyResultOptional.orElseThrow(() -> new NotFoundException("KeyResult not found"));
    }
}
