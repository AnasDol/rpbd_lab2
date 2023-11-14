package models;

import javax.persistence.*;

@Entity
@Table(name = "participations")
public class Participation implements MyEntity {

    @EmbeddedId
    private ParticipationId id;

    @Column(name = "reward", columnDefinition = "text")
    private String reward;

    public Participation() {
    }

    public Participation(ParticipationId id, String reward) {
        this.id = id;
        this.reward = reward;
    }

    public ParticipationId getId() {
        return id;
    }

    public void setId(ParticipationId id) {
        this.id = id;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", reward='" + reward + '\'' +
                '}';
    }
}