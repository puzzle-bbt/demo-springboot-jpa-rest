package ch.puzzle.demo.model.database.results;

import ch.puzzle.demo.model.database.KeyResult;
import ch.puzzle.demo.model.database.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    private String description;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "RESULT_PERSON_ID_FK"))
    private User createdBy;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "key_result_id", foreignKey = @ForeignKey(name = "KEY_RESULT_ID_FK"))
    private KeyResult keyResult;

    @CreatedDate
    private LocalDateTime createdOn;
}
