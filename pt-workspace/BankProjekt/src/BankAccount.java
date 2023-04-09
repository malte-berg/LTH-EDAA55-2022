public class BankAccount {
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och
	* id 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	private Customer holder;
	private int accountNr;
	private double amount = 0;
	private static int currentNr = 1001;
	
	public BankAccount(String holderName, long holderId) {
		holder = new Customer(holderName, holderId);
		accountNr = currentNr;
		currentNr++;
	}
	/**
	* Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	public BankAccount(Customer holder) {
		this.holder = holder;
		accountNr = currentNr;
		currentNr++;
	}
	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}
	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNumber() {
	    return accountNr;
	}
	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmount() {
		return amount;
	}
	/** Sätter in beloppet 'amount' på kontot. */
	public void deposit(double amount) {
		this.amount += amount;
	}
	/**
	* Tar ut beloppet 'amount' från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	public void withdraw(double amount) {
		this.amount -= amount;
	}
	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return "Konto " + accountNr + " (" + holder.toString() + "), Saldo: " + amount;
	}
}