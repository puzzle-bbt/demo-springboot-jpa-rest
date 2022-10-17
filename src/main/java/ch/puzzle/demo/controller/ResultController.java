package ch.puzzle.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.puzzle.demo.model.Result;
import ch.puzzle.demo.repository.ResultCrudRepository;

@RestController
@RequestMapping("results")
public class ResultController {

    private static final Logger LOG = LoggerFactory.getLogger(ObjectiveController.class);

    private final ResultCrudRepository resultCrudRepository;

    public ResultController(ResultCrudRepository resultCrudRepository) {
        this.resultCrudRepository = resultCrudRepository;
    }

    @GetMapping
    public List<Result> getAllResults() {
        LOG.info("Get all results");
        return (List<Result>) resultCrudRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Result> getResult(@PathVariable long id) {
        LOG.info("getResult with id '{}'", id);
        return resultCrudRepository.findById(id);
    }
}
