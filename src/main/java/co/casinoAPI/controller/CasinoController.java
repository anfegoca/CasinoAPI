package co.casinoAPI.controller;

import java.util.List;
import java.util.Random;

import co.casinoAPI.exceptions.CasinoException;
import co.casinoAPI.entities.Bet;
import co.casinoAPI.entities.Bill;
import co.casinoAPI.services.factory.BetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.casinoAPI.entities.Roulette;
import co.casinoAPI.services.factory.RouletteFactory;
import co.casinoAPI.services.RouletteService;

@RestController
public class CasinoController {
    @Autowired
    RouletteService rouletteService;
    private int generateId() {
        Random random = new Random();
        int id = random.nextInt(100000) + 1;

        return id;
    }
    @GetMapping("/createRoulette")
    public int createRoulette() {
        int id = generateId();
        while (rouletteService.idExists(id)) {
            id = generateId();
        }
        rouletteService.saveRoulette(RouletteFactory.getInstance().createRoulette(id));

        return id;
    }
    @GetMapping("/openRoulette")
    public boolean openRoulette(@RequestParam int id) {

        return rouletteService.openRoulette(id);
    }
    @GetMapping("/betColor")
    public boolean betColor(@RequestParam int id, @RequestParam String color, @RequestParam int value, @RequestHeader int userId){
        Bet bet = null;
        try {
            bet = BetFactory.getInstance().createBet(userId, value, color);
        }catch (CasinoException exception){

            return false;
        }

        return rouletteService.bet(id,bet);
    }
    @GetMapping("/betNumber")
    public boolean betNumber(@RequestParam int id, @RequestParam int number, @RequestParam int value, @RequestHeader int userId){
        Bet bet = null;
        try{
            bet = BetFactory.getInstance().createBet(userId, value, number);
        }catch (CasinoException exception){

            return false;
        }

        return rouletteService.bet(id, bet);
    }
    @GetMapping("/closeRoulette")
    public List<Bill> closeRoulette(@RequestParam int id){

        return rouletteService.closeRoulette(id);
    }
    @GetMapping("/getRoulettes")
    public List<Roulette> getRoulettes() {
        
        return rouletteService.findAll();
    }
    @GetMapping("/deleteAll")
    public void deleteAll(){
        rouletteService.deleteAll();
    }
}
