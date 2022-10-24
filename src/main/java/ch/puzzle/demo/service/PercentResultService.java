package ch.puzzle.demo.service;

import ch.puzzle.demo.model.database.results.PercentResult;
import ch.puzzle.demo.model.dto.result.PercentResultDto;
import ch.puzzle.demo.repository.KeyResultCrudRepository;
import ch.puzzle.demo.repository.UserCrudRepository;
import ch.puzzle.demo.repository.result.PercentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PercentResultService extends ResultService {
    private final PercentResultRepository percentResultRepository;
    private final UserService userService;


    @Autowired
    public PercentResultService(UserService userService, PercentResultRepository percentResultRepository, UserCrudRepository userCrudRepository, KeyResultCrudRepository keyResultCrudRepository) {
        super(keyResultCrudRepository);
        this.userService = userService;
        this.percentResultRepository = percentResultRepository;
    }

    public List<PercentResult> getAllPercentResults() {
        return this.percentResultRepository.findAll();
    }

    public PercentResult createPercentResult(PercentResultDto percentResultDto) {
        return this.percentResultRepository.save(PercentResult.builder()
                .name(percentResultDto.getName())
                .description(percentResultDto.getDescription())
                .percentValue(percentResultDto.getPercentValue())
                .createdOn(LocalDateTime.now())
                .createdBy(this.userService.findUserWithId(1L)) //TODO: Replace with current authorized user
                .keyResult(findKeyResultWithId(percentResultDto.getKeyResult()))
                .build());
    }
}
