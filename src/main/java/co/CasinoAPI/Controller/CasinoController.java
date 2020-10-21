package co.CasinoAPI.Controller;

import java.util.List;
import java.util.Random;

import co.CasinoAPI.Exceptions.CasinoException;
import co.CasinoAPI.entities.Bet;
import co.CasinoAPI.entities.Bill;
import co.CasinoAPI.services.Factory.BetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.CasinoAPI.entities.Roulette;
import co.CasinoAPI.services.Factory.RouletteFactory;
import co.CasinoAPI.services.RouletteService;

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
    public boolean betColor(@RequestParam int id, @RequestParam char color, @RequestParam int value, @RequestHeader int userId){
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

}
