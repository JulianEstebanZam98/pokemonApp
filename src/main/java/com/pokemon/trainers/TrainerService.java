package com.pokemon.trainers;

public class TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public TrainerDto getById(int id) {
        return trainerRepository.getById(id);
    }

    public TrainerDto[] getAll() {
        return trainerRepository.getAll();
    }

    public TrainerDto create(PayloadTrainerDto trainer) {
        return trainerRepository.create(trainer);
    }

    public TrainerDto update(int id, PayloadTrainerDto trainer) {
        TrainerDto existingTrainer = trainerRepository.getById(id);

        if (existingTrainer == null) {
            return null;
        }

        existingTrainer.setName(trainer.getName());
        existingTrainer.setCity(trainer.getCity());
        existingTrainer.setPokemons(trainer.getPokemons());


        return trainerRepository.update(existingTrainer);
    }

    public void delete(String id) {
        trainerRepository.delete(id);
    }
}
