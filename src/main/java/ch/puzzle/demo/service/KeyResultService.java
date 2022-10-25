package ch.puzzle.demo.service;

import ch.puzzle.demo.model.database.KeyResult;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class KeyResultService {
    private final KeyResultCrudRepository keyResultCrudRepository;

    public KeyResultService(KeyResultCrudRepository keyResultCrudRepository) {
        this.keyResultCrudRepository = keyResultCrudRepository;
    }

    public KeyResult findKeyResultById(Long id) {
        return this.keyResultCrudRepository.findById(id).orElseThrow(() -> new NotFoundException("KeyResult not found!"));
    }
}
