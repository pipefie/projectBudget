package personalbudgetingapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DataStorage {
	
	private HashMap<String, String> appUsers;
	private HashMap<String, HashMap<Date, ArrayList<Income>>> incomesMapUser;
	private HashMap<String, HashMap<Date, ArrayList<Expenses>>> expensesMapUser;
	
	public HashMap<String, String> getUsersLogin() {
		return appUsers;
	}
	public void setUsersLogin(HashMap<String, String> usersLogin) {
		this.appUsers = usersLogin;
	}
	public HashMap<String, HashMap<Date, ArrayList<Income>>> getIncomesMapUser() {
		return incomesMapUser;
	}
	public void setIncomesMapUser(HashMap<String, HashMap<Date, ArrayList<Income>>> incomesMapUser) {
		this.incomesMapUser = incomesMapUser;
	}
	public HashMap<String, HashMap<Date, ArrayList<Expenses>>> getExpensesMapUser() {
		return expensesMapUser;
	}
	public void setExpensesMapUser(HashMap<String, HashMap<Date, ArrayList<Expenses>>> expensesMapUser) {
		this.expensesMapUser = expensesMapUser;
	}
	@Override
	public String toString() {
		return "DataStorage [usersLogin=" + appUsers + ", incomesMapUser=" + incomesMapUser + ", expensesMapUser="
				+ expensesMapUser + "]";
	}
	public DataStorage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataStorage(HashMap<String, String> usersLogin,
			HashMap<String, HashMap<Date, ArrayList<Income>>> incomesMapUser,
			HashMap<String, HashMap<Date, ArrayList<Expenses>>> expensesMapUser) {
		super();
		this.appUsers = usersLogin;
		this.incomesMapUser = incomesMapUser;
		this.expensesMapUser = expensesMapUser;
	}
	
	public void addIncome(User usuario) {
		//continuar añadiendo y organizando info
	}
	
	
	
	
	

	
	
	
	/*
	 * organizar la informacion de la mejor forma para almacenarla en el fichero
	 */
	

}
