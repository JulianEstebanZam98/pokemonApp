package com.pokemon.trainers;
import java.util.Arrays;

public class PokemonService {
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonDto getById(String id) {
        return pokemonRepository.getById(id);
    }

    public AbilityDto[] getAbilities(int page) {
        PaginatedResponse response = pokemonRepository.getAbilities(page);
        AbilityDto[] abilities = response.getResults();
        Arrays.sort(abilities, (a, b) -> a.getName().compareTo(b.getName()));

        return response.getResults();

    }

}
