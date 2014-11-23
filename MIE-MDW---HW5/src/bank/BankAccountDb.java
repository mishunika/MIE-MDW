package bank;

import java.util.ArrayList;

public class BankAccountDb {
    private static ArrayList<BankAccount> db;
 
    private BankAccountDb() {
        
    }
    
    public static void init() {
    	if(db == null) {
	    	db = new ArrayList<BankAccount>();
	    	 
	        BankAccount b1 = new BankAccount(1, 10000);
	        BankAccount b2 = new BankAccount(2, 1000);
	        BankAccount b3 = new BankAccount(3, 5000);
	 
	        db.add(b1);
	        db.add(b2);
	        db.add(b3);
    	}
    }
    
    public static BankAccount getAccountById(int i) {
    	init();
    	for(BankAccount ba : db) {
    		if(ba.getNumber() == i) {
    			return ba;
    		}
    	}
    	return null;
    }
}