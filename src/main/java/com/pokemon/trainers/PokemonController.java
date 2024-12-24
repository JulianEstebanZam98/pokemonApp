package com.pokemon.trainers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class PokemonController {
    private PokemonService pokemonService = new PokemonService(new PokemonRepositoryImpl());

    @GetMapping("/pokemon/{id}")
    public PokemonDto getById(@PathVariable("id") String id) {
        return pokemonService.getById(id);
    }

    @GetMapping("/abilities/{page}")
    public AbilityDto[] getAbilities(@PathVariable("page") int page) {
        return pokemonService.getAbilities(page);
    }

}

class PokemonRepositoryImpl implements PokemonRepository {
    private RestClient httpClient = RestClient.builder()
            .baseUrl("https://pokeapi.co/api/v2")
            .build();

    @Override
    public PokemonDto getById(String id) {
        PokemonDto result = this.httpClient.get().uri("/pokemon/" + id).retrieve().body(PokemonDto.class);

        return result;
    }

    @Override
    public PaginatedResponse getAbilities(int page) {
        PaginatedResponse result = this.httpClient.get().uri("/ability/?limit=50&offset=" + page).retrieve().body(PaginatedResponse.class);

        return result;
    }
}