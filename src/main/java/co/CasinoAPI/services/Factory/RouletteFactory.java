package co.CasinoAPI.services.Factory;

import co.CasinoAPI.entities.Roulette;

public class RouletteFactory {

    private static class helper {
        private static final RouletteFactory INSTANCE = new RouletteFactory();
    }

    public static RouletteFactory getInstance() {

        return helper.INSTANCE;
    }

    public Roulette createRoulette(int id){

        return new Roulette(id);
    }
}
