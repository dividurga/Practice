package bankingApplication;

public class CheckingsAccount {
	public CheckingsAccount() {
		this.balance = 0;

		this.setAccnumber(count);
		count++;

	}

	private long accnumber;
	private static long count = 1;

	private double balance;

	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}

	public void withdraw(double amount) {
		if (amount > this.balance) {
			System.out.println("Insufficient balance");

		}
		else this.balance = balance - amount;
	}

	public void deposit(double amount) {
		this.balance = balance + amount;
	}

	public long getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(long accnumber) {
		this.accnumber = accnumber;
	}

	
}
