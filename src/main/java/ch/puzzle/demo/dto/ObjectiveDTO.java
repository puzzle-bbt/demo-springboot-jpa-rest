package ch.puzzle.demo.dto;

import java.util.Date;

public class ObjectiveDTO {

    public String title;
    public String description;
    public long createdById;
    public Date createdOn;

    public ObjectiveDTO() {}

    public ObjectiveDTO(String title, String description, long createdById, Date createdOn) {
        this.title = title;
        this.description = description;
        this.createdById = createdById;
        this.createdOn = createdOn;
    }
}
