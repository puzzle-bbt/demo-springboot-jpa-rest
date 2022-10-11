package ch.puzzle.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private long value;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "RESULT_PERSON_ID_FK"))
    private User createdBy;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "key_result_id", foreignKey = @ForeignKey(name = "KEY_RESULT_ID_FK"))
    private KeyResult keyResult;

    private Date createdOn;

}
