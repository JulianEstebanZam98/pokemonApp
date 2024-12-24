package com.pokemon.trainers;

public class TrainerDto {
    private int id;
    private String name;
    private String city;
    private String[] pokemons;
    private int score;

    public TrainerDto(int id, String name, String city, String[] pokemons, int score) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.pokemons = pokemons;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String[] getPokemons() {
        return pokemons;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPokemons(String[] pokemons) {
        this.pokemons = pokemons;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

class PayloadTrainerDto {
    private String name;
    private String city;
    private String[] pokemons;

    public PayloadTrainerDto( String name, String city, String[] pokemons) {
        this.name = name;
        this.city = city;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String[] getPokemons() {
        return pokemons;
    }
}