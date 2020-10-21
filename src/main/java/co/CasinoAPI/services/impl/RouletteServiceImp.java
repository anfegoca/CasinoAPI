package co.CasinoAPI.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.CasinoAPI.entities.Bet;
import org.springframework.stereotype.Component;

import co.CasinoAPI.entities.Roulette;
import co.CasinoAPI.services.RouletteService;

@Component
public class RouletteServiceImp implements RouletteService {

    private final List<Roulette> roulettes = new ArrayList<>();

    @Override
    public boolean saveRoulette(Roulette roulette) {

        return roulettes.add(roulette);
    }

    @Override
    public Roulette findById(int id) {
        Roulette roulette = null;
        for(Roulette r: roulettes){
            if(r.getId() == id){
                roulette = r;
            }
        }

        return roulette;
    }

    @Override
    public boolean idExists(int id) {
        boolean exists = false;
        for(Roulette r: roulettes){
            if(r.getId() == id){
                exists = true;
                break;
            }
        }
        return exists;
    }

    @Override
    public List<Roulette> findAll() {
        
        return roulettes;
    }

    @Override
    public boolean openRoulette(int id) {
        return findById(id).open();
    }

    @Override
    public boolean bet(int id, Bet bet) {

        return findById(id).bet(bet);
    }


}
