package ch.puzzle.demo.model.dto.result;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.Result} entity
 */
@Data
@SuperBuilder
public abstract class ResultDto implements Serializable {
    @NotBlank
    private final String name;

    @NotNull
    private final Long keyResult;

    private final String description;
}