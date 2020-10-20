package co.CasinoAPI.services;

import co.CasinoAPI.Exceptions.CasinoException;
import co.CasinoAPI.entities.Bet;
import co.CasinoAPI.entities.BetColor;
import co.CasinoAPI.entities.BetNumber;

public class BetFactory {
    private static class helper {
        private static final BetFactory INSTANCE = new BetFactory();
    }

    public static BetFactory getInstance() {

        return BetFactory.helper.INSTANCE;
    }

    public Bet createBet(int userId, int value, char color) throws CasinoException {
        if(value < 0 || value > 10000){
            throw new CasinoException(CasinoException.INVALID_VALUE);
        }else if(!(color == 'b' || color == 'r')){
            throw new CasinoException(CasinoException.INVALID_COLOR);
        }else{
            return new BetColor(userId, value, color);
        }
    }

    public Bet createBet(int userId, int value, int number){

        return new BetNumber(userId, value, number);
    }

}
