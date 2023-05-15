package personalbudgetingapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Statistics {
	
	private User usuario;
	private ArrayList<Income> incomeListUser = usuario.getListIncome();
	private ArrayList<Expenses> expenseListUser = usuario.getListExpenses();
	private HashMap<Date, Income> incomeMap = new HashMap<>();
	private HashMap<Date, Expenses> expensesMap = new HashMap<>();
	
	

	public Statistics() {
		// TODO Auto-generated constructor stub
	}

}
