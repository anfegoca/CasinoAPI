package co.CasinoAPI.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Component;

import co.CasinoAPI.entities.Roulette;
import co.CasinoAPI.services.RouletteService;

@Component
public class RouletteServiceImp implements RouletteService {

    private List<Roulette> roulettes = new ArrayList<>();

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

    
    
}
