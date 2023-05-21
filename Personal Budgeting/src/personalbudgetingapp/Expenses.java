package personalbudgetingapp;

import java.util.Currency;
import java.util.GregorianCalendar;

public class Expenses extends Transaction {
	private String categoryofExpense;
	

	public String getCategory() {
		return categoryofExpense;
	}

	public void setCategory(String categoryofExpense) {
		this.categoryofExpense = categoryofExpense;
	}

	public Expenses() {
		// TODO Auto-generated constructor stub
	}

	public Expenses(Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction, String categoryofExpense,
			GregorianCalendar dateofTransaction, String comments) {
		super(accountofTransaction, amountofTransaction, currencyofTransaction, dateofTransaction, comments);
		this.categoryofExpense = categoryofExpense;
	}

	@Override
	public String toString() {
		return categoryofExpense + String.valueOf(getAmountofTransaction())+"\n"+String.valueOf(getDateofTransaction());
	}
	
	public String details() {
		return "Account: "+ getAccountofTransaction().getAccountName()
				+"\nAmount: "+ getAmountofTransaction()+getCurrencyofTransaction().getSymbol()+
				"\nCategory: "+getCategory()+"\nDate: "+getDateofTransaction().getTime().toString();
		}

}
