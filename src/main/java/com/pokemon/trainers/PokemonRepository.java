package com.pokemon.trainers;

public interface PokemonRepository {
    PokemonDto getById(String id);
    PaginatedResponse getAbilities(int page);
}

class PaginatedResponse {
    private int count;
    private String next;
    private String previous;
    private AbilityDto[] results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public AbilityDto[] getResults() {
        return results;
    }
}