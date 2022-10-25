package ch.puzzle.demo.model.dto.result;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.TextResult} entity
 */
@Getter
public class TextResultDto extends ResultDto implements Serializable {
    private final String textValue;

    public TextResultDto(@NotBlank String name, @NotNull Long keyResult, String description, String textValue) {
        super(name, keyResult, description);
        this.textValue = textValue;
    }
}