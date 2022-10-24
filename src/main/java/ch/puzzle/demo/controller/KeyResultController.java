package ch.puzzle.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.puzzle.demo.model.database.KeyResult;
import ch.puzzle.demo.repository.KeyResultCrudRepository;

@RestController
@RequestMapping("api/keyresult")
public class KeyResultController {
    private static final Logger LOG = LoggerFactory.getLogger(KeyResultController.class);
    private final KeyResultCrudRepository keyResultRepository;

    public KeyResultController(KeyResultCrudRepository keyResultRepository) {
        this.keyResultRepository = keyResultRepository;
    }

    @GetMapping("")
    public List<KeyResult> getAllObjectives() {
        LOG.info("Get all KeyResults");
        return (List<KeyResult>) this.keyResultRepository.findAll();
    }
}
