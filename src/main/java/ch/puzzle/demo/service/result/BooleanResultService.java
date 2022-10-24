package ch.puzzle.demo.service.result;

import ch.puzzle.demo.model.database.results.BooleanResult;
import ch.puzzle.demo.model.dto.result.BooleanResultDto;
import ch.puzzle.demo.repository.result.BooleanResultRepository;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import ch.puzzle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BooleanResultService extends ResultService {
    private final BooleanResultRepository booleanResultRepository;
    private final UserService userService;

    @Autowired
    public BooleanResultService(UserService userService, KeyResultCrudRepository keyResultCrudRepository, BooleanResultRepository booleanResultRepository) {
        super(keyResultCrudRepository);
        this.userService = userService;
        this.booleanResultRepository = booleanResultRepository;
    }

    public List<BooleanResult> getAllBooleanResults() {
        return this.booleanResultRepository.findAll();
    }

    public BooleanResult createBooleanResult(BooleanResultDto booleanResultDto) {
        return BooleanResult.builder()
                .name(booleanResultDto.getName())
                .description(booleanResultDto.getDescription())
                .createdOn(LocalDateTime.now())
                .createdBy(this.userService.findUserWithId(1L)) //TODO: Replace with current authorized user
                .keyResult(this.findKeyResultWithId(booleanResultDto.getKeyResult()))
                .booleanValue(booleanResultDto.getBooleanValue())
                .build();
    }
}
