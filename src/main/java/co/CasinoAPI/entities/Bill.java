package co.CasinoAPI.entities;

public class Bill {
    private int userId;
    private double gain;

    public Bill(int userId, double gain) {
        this.userId = userId;
        this.gain = gain;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    
}
