package co.CasinoAPI.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.CasinoAPI.entities.Bet;
import co.CasinoAPI.entities.Bill;

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
        for (Roulette r : roulettes) {
            if (r.getId() == id) {
                roulette = r;
            }
        }

        return roulette;
    }

    @Override
    public boolean idExists(int id) {
        boolean exists = false;
        for (Roulette r : roulettes) {
            if (r.getId() == id) {
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
        Roulette roulette = findById(id);
        if(roulette == null){
            return false;
        }else{

            return roulette.open();    
        }

    }

    @Override
    public boolean bet(int id, Bet bet) {
        Roulette roulette = findById(id);
        if(roulette == null){

            return false;
        }else{

            return roulette.bet(bet);
        }
    }

    @Override
    public List<Bill> closeRoulette(int id) {
        Roulette roulette = findById(id);
        if(roulette == null){
            
            return null;
        }else{

            return roulette.close();
        }
    }


}
