package co.CasinoAPI.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.CasinoAPI.services.RouletteFactory;
import co.CasinoAPI.services.RouletteService;

@RestController
public class CasinoController {

    @Autowired
    RouletteService rouletteService;


    private int generateId(){
        Random random = new Random();
        int id = random.nextInt(100000)+1;

        return id;
    }
    
    @GetMapping("/createRoulette")
    public int createRoulette(){
        int id = generateId();
        while(rouletteService.idExists(id)){
            id = generateId();
        }
        rouletteService.saveRoulette(RouletteFactory.getInstance().createRoulette(id));
        
        return id;
    }
}
