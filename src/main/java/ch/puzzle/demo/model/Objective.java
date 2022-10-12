package ch.puzzle.demo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


@Entity
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

    @NotBlank
    private Date createdOn;

    public Objective() {
    }

    public Objective(long id, String title, String description, User createdBy, Date createdOn) {
        this.id = id;
        this.title = title;
        this.description = description;
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
        Objective objective = (Objective) o;
        return id == objective.id && title.equals(objective.title) && Objects.equals(description, objective.description) && createdBy.equals(objective.createdBy) && createdOn.equals(objective.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, createdBy, createdOn);
    }
}