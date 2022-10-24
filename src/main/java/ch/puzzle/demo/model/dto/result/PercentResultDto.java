package ch.puzzle.demo.model.dto.result;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.results.PercentResult} entity
 */
@Builder
@Getter
public class PercentResultDto extends ResultDto implements Serializable {
    @Min(0)
    @Max(100)
    private final Double percentValue;

    public PercentResultDto(Double percentValue, String name, String description, Integer keyResult) {
        super(name, keyResult, description);
        this.percentValue = percentValue;
    }
}