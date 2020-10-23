package co.casinoAPI.services.impl;

import java.util.ArrayList;
import java.util.List;
import co.casinoAPI.repository.RouletteRepository;
import co.casinoAPI.entities.Bet;
import co.casinoAPI.entities.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.casinoAPI.entities.Roulette;
import co.casinoAPI.services.RouletteService;

@Component
public class RouletteServiceImp implements RouletteService {
    @Autowired
    private RouletteRepository rouletteRepository;
    @Override
    public void saveRoulette(Roulette roulette) {
        rouletteRepository.save(roulette);
    }
    @Override
    public Roulette findById(int id) {

        return rouletteRepository.findById(id).get();
    }
    @Override
    public boolean idExists(int id) {

        return rouletteRepository.existsById(id);
    }
    @Override
    public List<Roulette> findAll() {
        List<Roulette> roulettes = new ArrayList<>();
        for(Roulette r: rouletteRepository.findAll()){
            roulettes.add(r);
        }

        return roulettes;
    }
    @Override
    public boolean openRoulette(int id) {
        boolean done;
        Roulette roulette = findById(id);
        if(roulette == null){
            done = false;
        }else{
            done = roulette.open();
            rouletteRepository.save(roulette);
        }

        return done;
    }
    @Override
    public boolean bet(int id, Bet bet) {
        boolean done;
        Roulette roulette = findById(id);
        if(roulette == null){
            done = false;
        }else{
            done = roulette.bet(bet);
            rouletteRepository.save(roulette);
        }

        return done;
    }
    @Override
    public List<Bill> closeRoulette(int id) {
        List<Bill> bills;
        Roulette roulette = findById(id);
        if(roulette == null){
            bills = null;
        }else{
            bills = roulette.close();
            rouletteRepository.save(roulette);
        }

        return bills;
    }
    @Override
    public void deleteAll() {
        rouletteRepository.deleteAll();
    }
}
