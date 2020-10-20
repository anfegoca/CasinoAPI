package co.CasinoAPI.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.CasinoAPI.entities.Roulette;
import co.CasinoAPI.services.RouletteFactory;
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
    @ResponseBody
    public boolean openRoulette(@RequestParam(required = true) int id) {

        return rouletteService.openRoulette(id);
    }

    @GetMapping("/getRoulettes")
    public List<Roulette> getRoulettes() {
        
        return rouletteService.findAll();
    }

}
