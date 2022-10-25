package ch.puzzle.demo.model.dto.result;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.BooleanResult} entity
 */
@Getter
public class BooleanResultDto extends ResultDto implements Serializable {
    private final Boolean booleanValue;

    public BooleanResultDto(@NotBlank String name, @NotNull Long keyResult, String description, Boolean booleanValue) {
        super(name, keyResult, description);
        this.booleanValue = booleanValue;
    }
}