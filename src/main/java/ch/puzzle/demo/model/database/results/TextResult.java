package ch.puzzle.demo.model.database.results;

import ch.puzzle.demo.model.database.KeyResult;
import ch.puzzle.demo.model.database.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "text_result")
@SuperBuilder
public class TextResult extends Result {
    @Column(name = "text_value")
    private String textValue;
}