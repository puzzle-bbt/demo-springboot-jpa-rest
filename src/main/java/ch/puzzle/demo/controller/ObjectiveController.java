package ch.puzzle.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import ch.puzzle.demo.exception.BusinessException;
import ch.puzzle.demo.dto.ObjectiveDTO;
import ch.puzzle.demo.model.Objective;
import ch.puzzle.demo.repository.ObjectiveService;

@RestController
@RequestMapping("objectives")
public class ObjectiveController {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectiveController.class);

    private final ObjectiveService objectiveService;
    public ObjectiveController(ObjectiveService objectiveService) {
        this.objectiveService = objectiveService;
    }

    @GetMapping
    public List<Objective> getAllObjectives() {
        LOG.info("Get all objectives");
        return (List<Objective>) objectiveService.getAllObjectives();
    }

    @GetMapping("/{id}")
    public Optional<Objective> getObjective(@PathVariable long id) {
        LOG.info("getAllObjectives with id '{}'", id);
        return objectiveService.getObjectiveById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createNewObjective(@RequestBody ObjectiveDTO objectiveDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(objectiveService.saveObjective(objectiveDTO));
        } catch (BusinessException e) {
            return ResponseEntity.status(e.code).body(e.getClientMessage());
        }
    }
}
