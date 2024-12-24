package com.pokemon.trainers;

public class PokemonDto {
    private int id;
    private String name;
    private int height;
    private int weight;
    private AbilityWrapperDto[] abilities;
    private SpeciesDto species;
    private FormsDto[] forms;

    public PokemonDto(int id, String name, int height, int weight, AbilityWrapperDto[] abilities, SpeciesDto species, FormsDto[] forms) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.species = species;
        this.forms = forms;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public AbilityWrapperDto[] getAbilities() {
        return abilities;
    }

    public SpeciesDto getSpecies() {
        return species;
    }

    public FormsDto[] getForms() {
        return forms;
    }
}

class AbilityDto {
    private String name;
    private String url;

    public AbilityDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

class AbilityWrapperDto{
    private AbilityDto ability;

    public AbilityDto getAbility() {
        return ability;
    }
}

class SpeciesDto {
    private String name;
    private String url;

    public SpeciesDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

class FormsDto {
    private String name;
    private String url;

    public FormsDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}