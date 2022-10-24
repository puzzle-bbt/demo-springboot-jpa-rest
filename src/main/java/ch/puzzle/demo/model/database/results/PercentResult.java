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
@Table(name = "percent_result")
@NoArgsConstructor
@SuperBuilder
public class PercentResult extends Result {
    @Column(name = "percent_value")
    private Double percentValue;
}