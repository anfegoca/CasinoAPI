package co.CasinoAPI.entities;

import java.util.ArrayList;
import java.util.List;

public class Roulette {
    private int id;
    private boolean open;
    private List<Bet> bets;

    public Roulette(int id){
        this.id=id;
        open=false;
        bets= new ArrayList<>();
    }

    public boolean open(){
        if(open){
            
            return false;
        }else{
            open = true;

            return true;
        }
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {

        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Bet> getBets() {

        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    
    
}
