package co.CasinoAPI.entities;

import co.CasinoAPI.services.Factory.BillFactory;

public class BetColor extends Bet {
    private char color;

    public BetColor(int userId, double value, char color) {
        super(userId, value);
        this.color=color;
    }

    public char getColor() {

        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public Bill collect(int number) {
        double gain = 0;
        if( (number % 2 == 0 && color == 'r') || (number % 2 == 1 && color == 'b') ){
            gain = value * 1.8;
        }

        return BillFactory.getInstance().createBill(userId, gain);
    }
}
