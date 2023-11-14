package models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ParticipationId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    public ParticipationId() {
    }

    public ParticipationId(Animal animal, Exhibition exhibition) {
        this.animal = animal;
        this.exhibition = exhibition;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Exhibition getExhibition() {
        return exhibition;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    @Override
    public String toString() {
        return "PositionId{" +
                "animal=" + animal.toShortString() +
                ", exhibition='" + exhibition.toShortString() + '\'' +
                '}';
    }
}