package ch.puzzle.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import ch.puzzle.demo.model.database.Objective;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import ch.puzzle.demo.repository.ObjectiveCrudRepository;

import static ch.puzzle.demo.model.helper.UrlLibrary.BASIC_URL;

@RestController
@RequestMapping(BASIC_URL + "/objectives")
public class ObjectiveController {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectiveController.class);
    private final ObjectiveCrudRepository objectiveCrudRepository;

    @Autowired
    public ObjectiveController(ObjectiveCrudRepository objectiveCrudRepository) {
        this.objectiveCrudRepository = objectiveCrudRepository;
    }

    @GetMapping("")
    public List<Objective> getAllObjectives() {
        LOG.info("Get all objectives");
        return (List<Objective>) this.objectiveCrudRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Objective> getObjective(@PathVariable long id) {
        LOG.info("getAllObjectives with id '{}'", id);
        return this.objectiveCrudRepository.findById(id);
    }
}
