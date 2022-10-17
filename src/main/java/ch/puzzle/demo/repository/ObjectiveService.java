package ch.puzzle.demo.repository;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import ch.puzzle.demo.dto.ObjectiveDTO;
import ch.puzzle.demo.model.Objective;
import ch.puzzle.demo.model.User;

@Service
public class ObjectiveService {

    private final ObjectiveCrudRepository objectiveCrudRepository;
    private final UserCrudRepository userCrudRepository;

    public ObjectiveService(ObjectiveCrudRepository objectiveCrudRepository, UserCrudRepository userCrudRepository) {
        this.objectiveCrudRepository = objectiveCrudRepository;
        this.userCrudRepository = userCrudRepository;
    }

    public Iterable<Objective> getAllObjectives() {
        return objectiveCrudRepository.findAll();
    }
    public Optional<Objective> getObjectiveById(long id) {
        return objectiveCrudRepository.findById(id);
    }
    public Objective saveObjective(ObjectiveDTO objectiveDTO) {

        User user = userCrudRepository.findById(objectiveDTO.createdById).orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (user!=null) {
            Date date = new Date();
            System.out.println(date);
            Objective objective = new Objective();
            objective.setTitle(objectiveDTO.title);
            objective.setDescription(objectiveDTO.description);
            objective.setCreatedBy(user);
            objective.setCreatedOn(date);
            return objectiveCrudRepository.save(objective);
        }
        return null;
    }
}
