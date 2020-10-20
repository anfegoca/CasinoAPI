package co.CasinoAPI.entities;

import java.util.ArrayList;
import java.util.List;

public class Roulette {
    private int id;
    private boolean open;
    private List<Bet> bets;

    public Roulette(int id){
        this.id=id;
        open=true;
        bets= new ArrayList<>();
    }
    
}
