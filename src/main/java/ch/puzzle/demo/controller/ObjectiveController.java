package ch.puzzle.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import ch.puzzle.demo.model.Objective;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import ch.puzzle.demo.repository.ObjectiveCrudRepository;

@RestController
@RequestMapping("api/objectives")
public class ObjectiveController {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectiveController.class);

    @Autowired
    ObjectiveCrudRepository objectiveCrudRepository;
    @Autowired
    KeyResultCrudRepository keyResultCrudRepository;

    @GetMapping("")
    public List<Objective> getAllObjectives() {
        LOG.info("Get all objectives");
        return (List<Objective>) objectiveCrudRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Objective> getObjective(@PathVariable long id) {
        LOG.info("getAllObjectives with id '{}'", id);
        return objectiveCrudRepository.findById(id);
    }
}
