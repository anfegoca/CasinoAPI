package co.CasinoAPI.services;

import co.CasinoAPI.entities.Roulette;

public interface RouletteService {

    public abstract boolean saveRoulette(Roulette roulette);

    public abstract Roulette findById(int id);

    public abstract boolean idExists(int id);

}
