package co.CasinoAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.CasinoAPI.entities.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Integer>{}
