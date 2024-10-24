package com.pokemon.dto;

public class PokemonDto {
    private Long id;
    private String name;
    private double weight;
    private int baseExperience;

    public PokemonDto(Long id, String name, double weight, int baseExperience) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.baseExperience = baseExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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