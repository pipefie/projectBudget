package personalbudgetingapp;

import java.util.ArrayList;

public class User {  
	private String email;
	private String password; 
	private String firstName;
	private String lasName;
	private ArrayList<Account> userAccounts;
	private ArrayList<Transaction> transactions;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	public ArrayList<Account> getUserAccounts() {
		return userAccounts;
	}
	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lasName=" + lasName
				+ ", userAccounts=" + userAccounts + ", transactions=" + transactions + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password, String firstName, String lasName, ArrayList<Account> userAccounts,
			ArrayList<Transaction> transactions) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lasName = lasName;
		this.userAccounts = userAccounts;
		this.transactions = transactions;
	}
	
	
	
	
	
	
	
	
	
	/* continuar:
	 * https://consumer.gov/managing-your-money/making-budget
	 * https://www.moneyhelper.org.uk/en/everyday-money/budgeting/use-our-budget-planner.html
	 * https://www.quicken.com/blog/budget-categories/
	 * 
	 * seguir en bases de datos:
	 * https://cassandra.apache.org/_/quickstart.html
	 * https://neo4j.com/developer/java/
	 */

}
