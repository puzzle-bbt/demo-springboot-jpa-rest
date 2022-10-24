package ch.puzzle.demo.service;

import ch.puzzle.demo.model.database.results.BooleanResult;
import ch.puzzle.demo.model.dto.result.BooleanResultDto;
import ch.puzzle.demo.repository.result.BooleanResultRepository;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import ch.puzzle.demo.repository.UserCrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BooleanResultService extends ResultService {
    private final BooleanResultRepository booleanResultRepository;

    public BooleanResultService(UserCrudRepository userCrudRepository, KeyResultCrudRepository keyResultCrudRepository, BooleanResultRepository booleanResultRepository) {
        super(userCrudRepository, keyResultCrudRepository);
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
                .createdBy(findUserWithId(1L))
                .keyResult(findKeyResultWithId(1L))
                .booleanValue(booleanResultDto.getBooleanValue())
                .build();
    }
}
