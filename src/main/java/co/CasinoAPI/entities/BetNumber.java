package co.CasinoAPI.entities;

public class BetNumber extends Bet{
    private int number;

    public BetNumber(int userId, int value, int number) {
        super(userId, value);
        this.number=number;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
