package bank;
 
public class BankAccount {
    private double balance;
    private int number;
 
    public BankAccount(int number, double balance) {
        this.balance = balance;
        this.number = number;
    }
 
    public double getBalance() {
        return balance;
    }
 
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public int getNumber() {
    	return number;
    }
}