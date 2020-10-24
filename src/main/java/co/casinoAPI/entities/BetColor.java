package co.casinoAPI.entities;

import co.casinoAPI.services.factory.BillFactory;

public class BetColor extends Bet{
    private String color;
    public BetColor(int userId, double value, String color) {
        super(userId, value);
        this.color=color;
    }
    @Override
    public Bill collect(int number) {
        double gain = 0;
        if( (number % 2 == 0 && "red".equals(color)) || (number % 2 == 1 && "black".equals(color)) ){
            gain = value * 1.8;
        }

        return BillFactory.getInstance().createBill(userId, gain);
    }
    public String getColor() {

        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
