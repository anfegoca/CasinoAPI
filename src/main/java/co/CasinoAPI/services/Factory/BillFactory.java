package co.CasinoAPI.services.Factory;

import co.CasinoAPI.entities.Bill;

public class BillFactory {

    private static class helper {
        private static final BillFactory INSTANCE = new BillFactory();
    }

    public static BillFactory getInstance() {

        return BillFactory.helper.INSTANCE;
    }
    
    public Bill createBill(int userId, double gain){
        
        return new Bill(userId, gain); 
    }
}
