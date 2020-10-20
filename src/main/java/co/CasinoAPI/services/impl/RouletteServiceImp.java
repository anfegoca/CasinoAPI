package co.CasinoAPI.services.impl;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

import co.CasinoAPI.entities.Roulette;
import co.CasinoAPI.services.RouletteService;

@Component
public class RouletteServiceImp implements RouletteService {

    private Hashtable<Integer,Roulette> roulettes= new Hashtable<>();

    @Override
    public boolean saveRoulette(Roulette roulette) {
        return false;
    }

    @Override
    public Roulette findById(int id) {
        return null;
    }

    @Override
    public boolean idExists(int id) {
        return roulettes.containsKey(id);
    }
    
}
