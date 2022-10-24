package ch.puzzle.demo.model.dto;

import ch.puzzle.demo.model.helper.ResultType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link ch.puzzle.demo.model.database.KeyResult} entity
 */
@Data
public class KeyResultDto implements Serializable {
    @NotBlank
    @NotNull
    private final String title;

    private final String description;

    @NotBlank
    private final ResultType result_type;

    private final Date createdOn;
}