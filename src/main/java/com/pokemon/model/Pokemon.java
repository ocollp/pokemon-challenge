package com.pokemon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private double weight;
    private int baseExperience;

    public Pokemon() {
    }

    public Pokemon(UUID id, String name, double weight, int baseExperience) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.baseExperience = baseExperience;
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }
}
