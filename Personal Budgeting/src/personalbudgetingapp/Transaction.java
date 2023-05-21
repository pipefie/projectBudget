package personalbudgetingapp;

import java.io.Serializable;
import java.util.Currency;
import java.util.GregorianCalendar;

public class Transaction implements Serializable {
	
	private Account accountofTransaction;
	private double amountofTransaction;
	private Currency currencyofTransaction;
	private GregorianCalendar dateofTransaction;
	private String comments;
	public Account getAccountofTransaction() {
		return accountofTransaction;
	}
	public void setAccountofTransaction(Account accountofTransaction) {
		this.accountofTransaction = accountofTransaction;
	}
	public double getAmountofTransaction() {
		return amountofTransaction;
	}
	public void setAmountofTransaction(double amountofTransaction) {
		this.amountofTransaction = amountofTransaction;
	}
	public Currency getCurrencyofTransaction() {
		return currencyofTransaction;
	}
	public void setCurrencyofTransaction(Currency currencyofTransaction) {
		this.currencyofTransaction = currencyofTransaction;
	}
	public GregorianCalendar getDateofTransaction() {
		return dateofTransaction;
	}
	public void setDateofTransaction(GregorianCalendar dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Transaction [accountofTransaction=" + accountofTransaction + ", amountofTransaction="
				+ amountofTransaction + ", currencyofTransaction=" + currencyofTransaction + ", dateofTransaction="
				+ dateofTransaction + ", comments=" + comments + "]";
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction,
			GregorianCalendar dateofTransaction, String comments) {
		super();
		this.accountofTransaction = accountofTransaction;
		this.amountofTransaction = amountofTransaction;
		this.currencyofTransaction = currencyofTransaction;
		this.dateofTransaction = dateofTransaction;
		this.comments = comments;
	}
	
	
	
	
	
	
	/* continuar con budget:
	 * https://n26.com/en-eu/blog/50-30-20-rule#:~:text=The%20basic%20rule%20of%20thumb,savings%20or%20paying%20off%20debt.
	 * https://whybudgeting.com/personal-budget-categories/
	 * https://localfirstbank.com/article/budgeting-101-personal-budget-categories/
	 * https://www.moneycrashers.com/home-personal-budget-categories-monthly/
	 * https://bettermoneyhabits.bankofamerica.com/en/saving-budgeting/creating-a-budget
	 * https://www.nerdwallet.com/article/finance/how-to-budget
	 * https://www.cnbc.com/select/how-to-create-a-budget-guide/
	 * https://homefamily.net/tracking-expenses-and-record-keeping/
	 */

}
