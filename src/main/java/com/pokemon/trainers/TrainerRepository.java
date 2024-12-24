package com.pokemon.trainers;

public interface TrainerRepository {
    TrainerDto getById(int id);
    TrainerDto[] getAll();
    TrainerDto create(PayloadTrainerDto trainer);
    TrainerDto update(TrainerDto trainer);
    void delete(String id);
}
