package co.casinoAPI.entities;

import co.casinoAPI.services.factory.BillFactory;

public class BetNumber extends Bet{
    private int number;
    public BetNumber(int userId, double value, int number) {
        super(userId, value);
        this.number=number;
    }
    @Override
    public Bill collect(int number) {
        double gain = this.number == number ? value * 5 : 0;  
        
        return BillFactory.getInstance().createBill(userId, gain);
    }
    public int getNumber() {

        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
