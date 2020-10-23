package co.casinoAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.casinoAPI.entities.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Integer>{}
