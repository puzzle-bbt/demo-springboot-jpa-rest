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
    private final UserCrudRepository userCrudRepository;
    private final KeyResultCrudRepository keyResultCrudRepository;

    @Autowired
    protected ResultService(UserCrudRepository userCrudRepository, KeyResultCrudRepository keyResultCrudRepository) {
        this.userCrudRepository = userCrudRepository;
        this.keyResultCrudRepository = keyResultCrudRepository;
    }

    protected User findUserWithId(Long id) {
        Optional<User> userOptional = this.userCrudRepository.findById(id);
        return  userOptional.orElseThrow(() -> new NotFoundException("User not found"));
    }

    protected KeyResult findKeyResultWithId(Long keyResultId) {
        Optional<KeyResult> keyResultOptional = this.keyResultCrudRepository.findById(keyResultId);
        return keyResultOptional.orElseThrow(() -> new NotFoundException("KeyResult not found"));
    }

}
