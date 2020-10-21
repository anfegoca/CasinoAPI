package co.CasinoAPI.services;

import java.util.List;

import co.CasinoAPI.entities.Bet;
import co.CasinoAPI.entities.Bill;
import co.CasinoAPI.entities.Roulette;

public interface RouletteService {

    boolean saveRoulette(Roulette roulette);

    Roulette findById(int id);

    boolean idExists(int id);

    List<Roulette> findAll();

    boolean openRoulette(int id);

    boolean bet(int id, Bet bet);

    List<Bill> closeRoulette(int id);

}
