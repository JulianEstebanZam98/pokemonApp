-- migrate:up
CREATE SCHEMA IF NOT EXISTS operations;
CREATE TABLE operations.trainers (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  city TEXT NOT NULL,
  pokemons VARCHAR(255)[] NOT NULL,
  score INTEGER NOT NULL
);
-- migrate:down
