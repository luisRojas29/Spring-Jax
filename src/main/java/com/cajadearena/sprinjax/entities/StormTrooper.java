package com.cajadearena.sprinjax.entities;

public class StormTrooper
{
	private String id;
    private String planetOfOrigin;
    private String species;
    private String type;

    public StormTrooper() {
        // empty to allow for bean access
    }

    public StormTrooper(String id, String planetOfOrigin, String species, String type) {
        this.id = id;
        this.planetOfOrigin = planetOfOrigin;
        this.species = species;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanetOfOrigin() {
        return planetOfOrigin;
    }

    public void setPlanetOfOrigin(String planetOfOrigin) {
        this.planetOfOrigin = planetOfOrigin;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
