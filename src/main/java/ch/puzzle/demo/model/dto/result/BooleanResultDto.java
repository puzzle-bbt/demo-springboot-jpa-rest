package ch.puzzle.demo.model.dto.result;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.BooleanResult} entity
 */
@SuperBuilder
@Getter
public class BooleanResultDto extends ResultDto implements Serializable {
    private final Boolean booleanValue;
}