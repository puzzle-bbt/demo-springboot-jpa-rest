package ch.puzzle.demo.model.dto.result;

import ch.puzzle.demo.model.dto.ResultDto;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.TextResult} entity
 */
@Builder
@Getter
public class TextResultDto extends ResultDto implements Serializable {
    @NotBlank
    private final String name;
    private final String description;
    private final LocalDateTime createdOn;
    private final String textValue;
}