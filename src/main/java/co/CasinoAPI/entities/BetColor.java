package co.CasinoAPI.entities;

public class BetColor extends Bet {
    private char color;

    public BetColor(int userId, int value, char color) {
        super(userId, value);
        this.color=color;
    }

    public char getColor() {

        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
