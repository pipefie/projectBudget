package personalbudgetingapp;

import java.util.Currency;
import java.util.GregorianCalendar;

public class Income extends Transaction {
	private String categoryofIncome;

	public String getCategory() {
		return categoryofIncome;
	}

	public void setCategory(String categoryofIncome) {
		this.categoryofIncome = categoryofIncome;
	}

	public Income() {
		// TODO Auto-generated constructor stub
	}

	public Income(Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction,
			GregorianCalendar dateofTransaction, String comments) {
		super(accountofTransaction, amountofTransaction, currencyofTransaction, dateofTransaction, comments);
		// TODO Auto-generated constructor stub
	}
	
	public Income(String categoryofIncome,Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction,
			GregorianCalendar dateofTransaction, String comments) {
		super(accountofTransaction, amountofTransaction, currencyofTransaction, dateofTransaction, comments);
		this.categoryofIncome = categoryofIncome;
	}

	@Override
	public String toString() {
		return  categoryofIncome + ":\n " +String.valueOf(getAmountofTransaction())+"\n "+getDateofTransaction().getTime().toString();
	}
	public String details() {
		return "Account: "+ getAccountofTransaction().getAccountName()
				+"\nAmount: "+ getAmountofTransaction()+getCurrencyofTransaction().getSymbol()+
				"\nCategory: "+getCategory()+"\nDate: "+getDateofTransaction().getTime().toString();
		}
	

}
