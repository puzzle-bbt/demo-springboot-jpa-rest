package ch.puzzle.demo.model.dto.result;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.PercentResult} entity
 */
@SuperBuilder
@Getter
public class PercentResultDto extends ResultDto implements Serializable {
    @Min(0)
    @Max(100)
    private final Double percentValue;
}