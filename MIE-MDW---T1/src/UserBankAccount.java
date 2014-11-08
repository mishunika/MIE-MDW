
public class UserBankAccount {
	private int amount;
	public UserBankAccount(int amount) {
		this.amount = amount;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
	public void subAmount(int amount) {
		this.amount -= amount;
	}
	
	public int getAmount() {
		return this.amount;
	}
}
