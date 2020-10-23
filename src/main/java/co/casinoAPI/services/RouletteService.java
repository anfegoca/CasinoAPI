package co.casinoAPI.services;

import java.util.List;

import co.casinoAPI.entities.Bet;
import co.casinoAPI.entities.Bill;
import co.casinoAPI.entities.Roulette;

public interface RouletteService {
    void saveRoulette(Roulette roulette);
    Roulette findById(int id);
    boolean idExists(int id);
    List<Roulette> findAll();
    boolean openRoulette(int id);
    boolean bet(int id, Bet bet);
    List<Bill> closeRoulette(int id);
    void deleteAll();
}
