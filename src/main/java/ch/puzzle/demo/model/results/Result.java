package ch.puzzle.demo.model.results;

import ch.puzzle.demo.model.KeyResult;
import ch.puzzle.demo.model.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;
    private String description;

//    @NotBlank
//    private long value;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "RESULT_PERSON_ID_FK"))
    private User createdBy;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "key_result_id", foreignKey = @ForeignKey(name = "KEY_RESULT_ID_FK"))
    private KeyResult keyResult;

    @CreatedDate
    private Date createdOn;
}
