package ch.puzzle.demo.model.results;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "percent_result")
public class PercentResult extends Result {
    @Column(name = "percent_value")
    private Double percentValue;

}