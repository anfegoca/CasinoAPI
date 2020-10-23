package co.casinoAPI.entities;

public abstract class Bet {
    protected int userId;
    protected double value;
    public Bet(int userId, double value){
        this.userId=userId;
        this.value=value;
    }
    public abstract Bill collect(int number);
    public int getUserId() {

        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public double getValue() {

        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
