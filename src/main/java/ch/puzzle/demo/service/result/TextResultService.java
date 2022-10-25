package ch.puzzle.demo.service.result;

import ch.puzzle.demo.model.database.results.TextResult;
import ch.puzzle.demo.model.dto.result.TextResultDto;
import ch.puzzle.demo.repository.result.TextResultRepository;
import ch.puzzle.demo.service.KeyResultService;
import ch.puzzle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TextResultService {
    private final TextResultRepository textResultRepository;
    private final UserService userService;
    private final KeyResultService keyResultService;

    @Autowired
    public TextResultService(TextResultRepository textResultRepository, UserService userService, KeyResultService keyResultService) {
        this.textResultRepository = textResultRepository;
        this.userService = userService;
        this.keyResultService = keyResultService;
    }

    public List<TextResult> getAllTextResults() {
        return this.textResultRepository.findAll();
    }

    public TextResult createTextResult(TextResultDto textResultDto) {
        return this.textResultRepository.save(TextResult.builder()
                .name(textResultDto.getName())
                .description(textResultDto.getDescription())
                .createdOn(LocalDateTime.now())
                .textValue(textResultDto.getTextValue())
                .createdBy(userService.findUserWithId(1L)) // TODO: Replace 1 with id of authorized user
                .keyResult(keyResultService.findKeyResultById(textResultDto.getKeyResult()))
                .build());
    }
}
