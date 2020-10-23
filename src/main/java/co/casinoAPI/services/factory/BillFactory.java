package co.casinoAPI.services.factory;

import co.casinoAPI.entities.Bill;

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
