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
    private Date createdOn;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "RESULT_PERSON_ID_FK"))
    private User createdBy;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "key_result_id", foreignKey = @ForeignKey(name = "KEY_RESULT_ID_FK"))
    private KeyResult keyResult;


    public Result() { }

    public Result(String name, String description, long value, Date createdOn, User createdBy, KeyResult keyResult) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.keyResult = keyResult;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public KeyResult getKeyResult() {
        return keyResult;
    }

    public void setKeyResult(KeyResult keyResult) {
        this.keyResult = keyResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id == result.id && value == result.value && name.equals(result.name) && Objects.equals(description, result.description) && createdOn.equals(result.createdOn) && createdBy.equals(result.createdBy) && keyResult.equals(result.keyResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, value, createdOn, createdBy, keyResult);
    }
}
