package ch.puzzle.demo.model.results;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "boolean_result")
public class BooleanResult extends Result {
    @Column(name = "boolean_value")
    private Boolean booleanValue;
}