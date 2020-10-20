package co.CasinoAPI.services;

import java.util.List;

import co.CasinoAPI.entities.Roulette;

public interface RouletteService {

    public abstract boolean saveRoulette(Roulette roulette);

    public abstract Roulette findById(int id);

    public abstract boolean idExists(int id);

    public abstract List<Roulette> findAll();

    public abstract boolean openRoulette(int id);

}
