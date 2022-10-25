package ch.puzzle.demo.model.dto.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.PercentResult} entity
 */
@Getter
public class PercentResultDto extends ResultDto implements Serializable {
    private final Double percentValue;

    public PercentResultDto(@NotBlank String name, @NotNull Long keyResult, String description, Double percentValue) {
        super(name, keyResult, description);
        this.percentValue = percentValue;
    }
}