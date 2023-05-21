package personalbudgetingapp;
import java.util.Currency;

public class Account {
	private String accountName;
	private String country;
	public enum AccountType {GENERAL, CASH, CURRENT_ACCOUNT, CREDIT_CARD, SAVING_ACCOUNT, INSURANCE, LOAN, INVESTMENT, MORTGAGE, BONUS, OTHER};
	private AccountType accountType;
	private Currency currencyAccount;
	private double starting_amount;
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getStarting_amount() {
		return starting_amount;
	}
	public void setStarting_amount(double starting_amount) {
		this.starting_amount = starting_amount;
	}
	public Currency getCurrencyAccount() {
		return currencyAccount;
	}
	public void setCurrencyAccount(Currency currencyAccount) {
		this.currencyAccount = currencyAccount;
	}
	@Override
	public String toString() {
		return accountName;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountName, String country, AccountType accountType, Currency currencyAccount,
			double starting_amount) {
		super();
		this.accountName = accountName;
		this.country = country;
		this.accountType = accountType;
		this.currencyAccount = currencyAccount;
		this.starting_amount = starting_amount;
	}

	public void updateAmountAccount (Transaction transaction) {

		if(transaction instanceof Income) {
			starting_amount = starting_amount + transaction.getAmountofTransaction();
		}
		else if (transaction instanceof Expenses) {
			starting_amount = starting_amount - transaction.getAmountofTransaction();
		}
	}
	
	public String details () {
		return "Account: "+accountName+"\nCountry: "+country+
				"\nType: "+accountType+"\nCurrent Amount: "+starting_amount+currencyAccount.getSymbol();
	}

	
	/*
	 * investigar como funciona currency:
	 * https://www.geeksforgeeks.org/java-util-currency-methods-example/
	 * continuar:
	 * https://budgetbakers.com/
	 */

	

}
