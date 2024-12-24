package com.pokemon.trainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {
    private TrainerService trainerService = new TrainerService(new TrainerPostgresRepository());

    @GetMapping("/trainer/{id}")
    public TrainerDto getById(@PathVariable("id") int id) {
        return trainerService.getById(id);
    }

    @GetMapping("/trainer")
    public TrainerDto[] getAll() {
        return trainerService.getAll();
    }

    @PostMapping("/trainer")
    public TrainerDto create(@RequestBody PayloadTrainerDto trainer) {
        return trainerService.create(trainer);
    }

    @PutMapping("/trainer/{id}")
    public TrainerDto update(@PathVariable("id") int id, @RequestBody PayloadTrainerDto trainer) {
        return trainerService.update(id, trainer);
    }

    @DeleteMapping("/trainer/{id}")
    public void delete(@PathVariable("id") String id) {
        trainerService.delete(id);
    }

}

@Repository
class TrainerPostgresRepository implements TrainerRepository {
    private final JdbcTemplate jdbcTemplate;

    public TrainerPostgresRepository() {
        this.jdbcTemplate = new JdbcTemplate();
        this.jdbcTemplate.setDataSource(DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/trainer")
                .username("postgres").password("postgres").driverClassName("org.postgresql.Driver").build());
    }

    @Override
    public TrainerDto getById(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM operations.trainers WHERE id = ?", new Object[] { id },
                new TrainerRowMapper());
    }

    @Override
    public TrainerDto[] getAll() {
        return this.jdbcTemplate.query("SELECT * FROM operations.trainers", new TrainerRowMapper())
                .toArray(new TrainerDto[0]);
    }

    @Override
    public TrainerDto create(PayloadTrainerDto trainer) {
        this.jdbcTemplate.update("INSERT INTO operations.trainers (name, city, pokemons, score) VALUES (?, ?, ?, ?)",
                trainer.getName(), trainer.getCity(), trainer.getPokemons(), 0);

        return this.jdbcTemplate.queryForObject("SELECT * FROM operations.trainers ORDER BY id DESC LIMIT 1",
                new TrainerRowMapper());
    }

    @Override
    public TrainerDto update(TrainerDto trainer) {
        this.jdbcTemplate.update(
                "UPDATE operations.trainers SET name = ?, city = ?, pokemons = ?, score = ? WHERE id = ?",
                trainer.getName(), trainer.getCity(), trainer.getPokemons(), trainer.getScore(),
                trainer.getId());

        return trainer;
    }

    @Override
    public void delete(String id) {
        this.jdbcTemplate.update("DELETE FROM operations.trainers WHERE id = ?", Integer.parseInt(id));
    }
}

class TrainerRowMapper implements RowMapper<TrainerDto> {
    @Override
    public TrainerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String city = rs.getString("city");
        String[] pokemons = (String[]) rs.getArray("pokemons").getArray();
        int score = rs.getInt("score");
        return new TrainerDto(id, name, city, pokemons, score);
    }
}