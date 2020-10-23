package co.casinoAPI.services.factory;

import co.casinoAPI.exceptions.CasinoException;
import co.casinoAPI.entities.Bet;
import co.casinoAPI.entities.BetColor;
import co.casinoAPI.entities.BetNumber;

public class BetFactory {
    private static class helper {
        private static final BetFactory INSTANCE = new BetFactory();
    }
    public static BetFactory getInstance() {

        return BetFactory.helper.INSTANCE;
    }
    public Bet createBet(int userId, int value, String color) throws CasinoException {
        if(value < 0 || value > 10000){
            throw new CasinoException(CasinoException.INVALID_VALUE);
        }else if(!("black".equals(color) || "red".equals(color))){
            throw new CasinoException(CasinoException.INVALID_COLOR);
        }else{

            return new BetColor(userId, value, color);
        }
    }
    public Bet createBet(int userId, int value, int number) throws CasinoException {
        if(value < 0 || value > 10000){
            throw new CasinoException(CasinoException.INVALID_VALUE);
        }else if(number < 0 || number > 36){
            throw new CasinoException(CasinoException.INVALID_NUMBER);
        }else{
            
            return new BetNumber(userId, value, number);
        }
    }
}
