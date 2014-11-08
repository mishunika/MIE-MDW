
public class MoneyManager {
	public static void main(String[] argv) {
		UserBankAccount u1 = new UserBankAccount(15000);
		UserBankAccount u2 = new UserBankAccount(7000);
		System.out.println("Innitial data:");
		System.out.println("User1 amount: " + u1.getAmount());
		System.out.println("User2 amount: " + u2.getAmount());
		
		transferMoney(u1, u2, 5000);
		
		System.out.println("\nAfter transfer of 5000 from User1 to User2:");
		System.out.println("User1 amount: " + u1.getAmount());
		System.out.println("User2 amount: " + u2.getAmount());
	}
	
	public static void transferMoney(UserBankAccount from, UserBankAccount to, int amount) {
		sub(from, amount);
		add(to, amount);
	}
	
	public static void add(UserBankAccount user, int amount) {
		user.addAmount(amount);
	}
	
	public static void sub(UserBankAccount user, int amount) {
		user.subAmount(amount);
	}
}
