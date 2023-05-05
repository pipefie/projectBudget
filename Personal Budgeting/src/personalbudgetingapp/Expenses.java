package personalbudgetingapp;

import java.util.Currency;
import java.util.GregorianCalendar;

public class Expenses extends Transaction {
	private CategoryofExpense category;
	

	public Expenses() {
		// TODO Auto-generated constructor stub
	}

	public Expenses(Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction,
			GregorianCalendar dateofTransaction, String comments) {
		super(accountofTransaction, amountofTransaction, currencyofTransaction, dateofTransaction, comments);
		// TODO Auto-generated constructor stub
	}

}
