package personalbudgetingapp;

import java.util.Currency;
import java.util.GregorianCalendar;

public class Income extends Transaction {
	private CategoryofIncome category;

	public CategoryofIncome getCategory() {
		return category;
	}

	public void setCategory(CategoryofIncome category) {
		this.category = category;
	}

	public Income() {
		// TODO Auto-generated constructor stub
	}

	public Income(Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction,
			GregorianCalendar dateofTransaction, String comments) {
		super(accountofTransaction, amountofTransaction, currencyofTransaction, dateofTransaction, comments);
		// TODO Auto-generated constructor stub
	}
	
	public Income(CategoryofIncome category,Account accountofTransaction, double amountofTransaction, Currency currencyofTransaction,
			GregorianCalendar dateofTransaction, String comments) {
		super(accountofTransaction, amountofTransaction, currencyofTransaction, dateofTransaction, comments);
		this.category = category;
	}

}
