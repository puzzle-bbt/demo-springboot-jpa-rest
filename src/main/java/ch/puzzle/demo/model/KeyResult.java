package ch.puzzle.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    private Date createdOn;
}
