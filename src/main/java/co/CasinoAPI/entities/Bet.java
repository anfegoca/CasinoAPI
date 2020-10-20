package co.CasinoAPI.entities;

public class Bet {
    private int userId;
    private int value;

    public Bet(int userId, int value){
        this.userId=userId;
        this.value=value;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
