package ch.puzzle.demo.model.database.results;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "boolean_result")
@NoArgsConstructor
@SuperBuilder
public class BooleanResult extends Result {
    @Column(name = "boolean_value")
    private Boolean booleanValue;
}