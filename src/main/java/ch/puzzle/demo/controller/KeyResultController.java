package ch.puzzle.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.puzzle.demo.model.KeyResult;
import ch.puzzle.demo.repository.KeyResultCrudRepository;

@RestController
@RequestMapping("keyresults")
public class KeyResultController {
    private static final Logger LOG = LoggerFactory.getLogger(KeyResultController.class);

    private final KeyResultCrudRepository keyResultRepository;

    public KeyResultController(KeyResultCrudRepository keyResultRepository) {
        this.keyResultRepository = keyResultRepository;
    }

    @GetMapping
    public List<KeyResult> getAllKeyResults() {
        LOG.info("Get all KeyResults");
        return (List<KeyResult>) keyResultRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<KeyResult> getKeyResult(@PathVariable long id) {
        LOG.info("getKeyResult with id '{}'", id);
        return keyResultRepository.findById(id);
    }
}
