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
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String title;

    private String description;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "OBJECTIVE_PERSON_ID_FK"))
    private User createdBy;

    private Date createdOn;

}