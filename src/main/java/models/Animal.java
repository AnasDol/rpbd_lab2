package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal implements MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;


    @Type(type = "models.GenderType")
    @Column(name = "gender")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @Column(name = "appearance")
    private String appearance;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Employee vet;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Animal mother;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Animal father;

    public Animal(String name, int age, Gender gender, Breed breed,
                  String appearance, Client client, Employee vet, Animal mother, Animal father) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.appearance = appearance;
        this.client = client;
        this.vet = vet;
        this.mother = mother;
        this.father = father;
    }

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getVet() {
        return vet;
    }

    public void setVet(Employee vet) {
        this.vet = vet;
    }

    public Animal getMother() {
        return mother;
    }

    public void setMother(Animal mother) {
        this.mother = mother;
    }

    public Animal getFather() {
        return father;
    }

    public void setFather(Animal father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", breed=" + breed +
                ", appearance='" + appearance + '\'' +
                ", client=" + client.toShortString() +
                ", vet=" + vet.toShortString() +
                ", mother=" + ((mother != null) ? mother.toShortString() : "null") +
                ", father=" + ((father != null) ? father.toShortString() : "null") +
                '}';
    }

    public String toShortString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}