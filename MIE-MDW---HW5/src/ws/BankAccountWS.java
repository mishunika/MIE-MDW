package ws;

import javax.jws.*;
 
import bank.BankAccount;
import bank.BankAccountDb;
 
@WebService
public class BankAccountWS {
    public boolean accountExists(int number) {
    	return BankAccountDb.getAccountById(number) != null;
    }
    
    public boolean checkBalance(int number, double amount) {
        BankAccount b = BankAccountDb.getAccountById(number);
        if(b != null) {
            return b.getBalance() >= amount;
        } else {
            return false;
        }
    }
    
    public boolean changeBalance(int number, double amount) {
        BankAccount b = BankAccountDb.getAccountById(number);
        if(b != null) {
            b.setBalance(b.getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }
}