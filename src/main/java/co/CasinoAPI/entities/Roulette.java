package co.CasinoAPI.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Roulette")
public class Roulette implements Serializable{
    private int id;
    private boolean open;
    private List<Bet> bets;

    public Roulette(int id) {
        this.id = id;
        open = false;
        bets = new ArrayList<>();
    }

    public boolean open() {
        if (open) {

            return false;
        } else {
            open = true;

            return true;
        }
    }

    public boolean bet(Bet bet) {
        if (open) {

            return bets.add(bet);
        } else {

            return false;
        }
    }

    public List<Bill> close() {
        if (!open) {

            return null;
        } else {
            open=false;
            List<Bill> bills = new ArrayList<>();
            int winningNumber = spin();
            System.out.println(winningNumber);
            for (Bet b : bets) {
                bills.add(b.collect(winningNumber));
            }
            bets.clear();

            return bills;
        }
    }

    private int spin() {
        Random random = new Random();
        int winningNumber = random.nextInt(36) + 1;

        return winningNumber;
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
