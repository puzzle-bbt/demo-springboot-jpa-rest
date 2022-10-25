package ch.puzzle.demo.model.database;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import ch.puzzle.demo.model.helper.ResultType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KeyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "objective_id", foreignKey = @ForeignKey(name = "OBJECTIVE_ID_FK"))
    private Objective objective;

    @NotBlank
    private ResultType result_type;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "KEYRESULT_PERSON_ID_FK"))
    private User createdBy;

    @CreatedDate
    private Date createdOn;
}
