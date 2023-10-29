package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParticipationId implements Serializable {

    @Column(name = "animal_id")
    private int animalId;

    @Column(name = "exhibition_id")
    private int exhibitionId;

    public ParticipationId(int animalId, int exhibitionId) {
        this.animalId = animalId;
        this.exhibitionId = exhibitionId;
    }

    public ParticipationId() {

    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }
}