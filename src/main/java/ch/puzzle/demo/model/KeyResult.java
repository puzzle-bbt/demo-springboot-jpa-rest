package ch.puzzle.demo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
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

    @NotBlank
    private Date createdOn;

    public KeyResult() {
    }

    public KeyResult(long id, String title, String description, Objective objective, ResultType result_type, User createdBy, Date createdOn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.objective = objective;
        this.result_type = result_type;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public ResultType getResult_type() {
        return result_type;
    }

    public void setResult_type(ResultType result_type) {
        this.result_type = result_type;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyResult keyResult = (KeyResult) o;
        return id == keyResult.id && title.equals(keyResult.title) && Objects.equals(description, keyResult.description) && objective.equals(keyResult.objective) && result_type == keyResult.result_type && createdBy.equals(keyResult.createdBy) && createdOn.equals(keyResult.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, objective, result_type, createdBy, createdOn);
    }
}
