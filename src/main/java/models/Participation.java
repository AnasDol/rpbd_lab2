package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participations")
public class Participation implements MyEntity {

    @EmbeddedId
    private ParticipationId id;

    @ManyToOne
    @MapsId("animalId")
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @MapsId("exhibitionId")
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    @Column(name = "reward", columnDefinition = "text")
    private String reward;

    public ParticipationId getId() {
        return id;
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

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
}