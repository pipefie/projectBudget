package personalbudgetingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DataStorage implements Serializable {
	
	
	private ArrayList<User> usuariosApp;
	private HashMap<String, String> appUsers; //user(email, password)
	private ArrayList<Income> incomeUserDaily;
	private HashMap<String, HashMap<Date, ArrayList<Income>>> incomesMapUser; // email, date/listIncome
	private ArrayList<Expenses> expensesUserDaily;
	private HashMap<String, HashMap<Date, ArrayList<Expenses>>> expensesMapUser; // email, date/listExpenses
	
	
	public ArrayList<User> getUsuariosApp() {
		return usuariosApp;
	}
	public void setUsuariosApp(ArrayList<User> usuariosApp) {
		this.usuariosApp = usuariosApp;
	}
	public HashMap<String, String> getAppUsers() {
		return appUsers;
	}
	public void setAppUsers(HashMap<String, String> appUsers) {
		this.appUsers = appUsers;
	}
	public ArrayList<Income> getIncomeUserDaily() {
		return incomeUserDaily;
	}
	public void setIncomeUserDaily(ArrayList<Income> incomeUserDaily) {
		this.incomeUserDaily = incomeUserDaily;
	}
	public ArrayList<Expenses> getExpensesUserDaily() {
		return expensesUserDaily;
	}
	public void setExpensesUserDaily(ArrayList<Expenses> expensesUserDaily) {
		this.expensesUserDaily = expensesUserDaily;
	}
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
		usuariosApp = new ArrayList<>();
		appUsers = new HashMap<>();
		incomesMapUser = new HashMap<>();
		expensesMapUser = new HashMap<>();
		
	}
	public DataStorage(HashMap<String, String> usersLogin,
			HashMap<String, HashMap<Date, ArrayList<Income>>> incomesMapUser,
			HashMap<String, HashMap<Date, ArrayList<Expenses>>> expensesMapUser) {
		super();
		this.appUsers = usersLogin;
		this.incomesMapUser = incomesMapUser;
		this.expensesMapUser = expensesMapUser;
	}
	
	//load the remaining data to the files and test OMG

	public User getUser (String email) {
		for (User user :usuariosApp) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}
	public void newUser (User newUser) {
		usuariosApp.add(newUser);
	}
	
	public boolean userHasIncome (User usuario, Income income) {
		return incomesMapUser.get(usuario.getEmail()).get(income.getDateofTransaction().getTime()).contains(income);
	}
	
	public boolean userHasExpense (User usuario, Expenses expense) {
		return expensesMapUser.get(usuario.getEmail()).get(expense.getDateofTransaction().getTime()).contains(expense);
	
	}
	
	public void deleteIncome(User usuario, Income income) {
		incomesMapUser.get(usuario.getEmail()).get(income.getDateofTransaction().getTime()).remove(income);
	}
	
	public void deleteExpense(User usuario, Expenses expense) {
		expensesMapUser.get(usuario.getEmail()).get(expense.getDateofTransaction().getTime()).remove(expense);
	}
	

	public void addUserIncome (User usuario, Income income) {
		
		if (incomesMapUser.containsKey(usuario.getEmail())) {
			HashMap<Date, ArrayList<Income>> mapaUsuario = incomesMapUser.get(usuario.getEmail());
			
			if (mapaUsuario.containsKey(income.getDateofTransaction().getTime())) {
				mapaUsuario.get(income.getDateofTransaction().getTime()).add(income);
			}
			
			else {
				incomeUserDaily = new ArrayList<>();
				incomeUserDaily.add(income);
				mapaUsuario.put(income.getDateofTransaction().getTime(), incomeUserDaily);
			}
		
		}
		
		else {
			incomeUserDaily = new ArrayList<>();
			incomeUserDaily.add(income);
			HashMap<Date, ArrayList<Income>> mapaUsuario = new HashMap<>();
			mapaUsuario.put(income.getDateofTransaction().getTime(), incomeUserDaily);
			incomesMapUser.put(usuario.getEmail(), mapaUsuario);
			
		}
		
	}
	
	public void addUserExpense (User usuario, Expenses expense) {

		if (expensesMapUser.containsKey(usuario.getEmail())) {
			HashMap<Date, ArrayList<Expenses>> mapaUsuario = expensesMapUser.get(usuario.getEmail());
			
			if (mapaUsuario.containsKey(expense.getDateofTransaction().getTime())) {
				mapaUsuario.get(expense.getDateofTransaction().getTime()).add(expense);
				
			}
			
			else {
				expensesUserDaily = new ArrayList<>();
				expensesUserDaily.add(expense);
				mapaUsuario.put(expense.getDateofTransaction().getTime(), expensesUserDaily);
			}		
		}
		
		else {
			expensesUserDaily = new ArrayList<>();
			expensesUserDaily.add(expense);
			HashMap<Date, ArrayList<Expenses>> mapaUsuario = new HashMap<>();
			mapaUsuario.put(expense.getDateofTransaction().getTime(), expensesUserDaily);
			expensesMapUser.put(usuario.getEmail(), mapaUsuario);
		}
		
	}
	

	public void readdDataUsers () {
		
		try {
			
			FileInputStream file = new FileInputStream("dataApp.bin");
			ObjectInputStream objectFileRead = new ObjectInputStream(file);
			ArrayList<User> cargaListaUsuarios = (ArrayList<User>) objectFileRead.readObject();
			loadDataUsers(cargaListaUsuarios);
			objectFileRead.close();
			file.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		 * continuar cargando ficheros y leyendo
		 * los datos terminar
		 * generar métodos
		 */
	}
	
	public void loadDataUsers (ArrayList<User> listaUsuarios) {
		usuariosApp = listaUsuarios;
		
		for (User user : listaUsuarios) {
			for (Income income : user.getListIncome()) {
				addUserIncome(user, income);
			}
			for (Expenses expense : user.getListExpenses()) {
				addUserExpense(user, expense);
			}
		}
	}
	
	public void writeDataUsers () {
		
		try {
			
			FileOutputStream file = new FileOutputStream("dataApp.bin");
			ObjectOutputStream objectFileWrite = new ObjectOutputStream(file);
			objectFileWrite.writeObject(usuariosApp);
			objectFileWrite.close();
			file.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void readDataCredentials () {
		
		try {
			FileInputStream file = new FileInputStream("dataCredentials.bin");
			ObjectInputStream objectFileRead = new ObjectInputStream(file);
			HashMap<String, String> mapCredentials =(HashMap<String, String>) objectFileRead.readObject();
			loadDataCredentials(mapCredentials);
			objectFileRead.close();
			file.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void loadDataCredentials (HashMap<String, String> credentials) {
		appUsers = credentials;
		
	}
	
	public void writeDataCredentials () {
		
		try {
			
			FileOutputStream file = new FileOutputStream("dataCredentials.bin");
			ObjectOutputStream objectFileWrite = new ObjectOutputStream(file);
			objectFileWrite.writeObject(appUsers);
			objectFileWrite.close();
			file.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkCredentials (String email, String password) {
		return (appUsers.containsKey(email) && appUsers.get(email).equals(password));
		}
			
	public void addAppUser (String email, String password) {
		appUsers.put(email, password);
	}
	
	public void removeAppUser (String email) {
		appUsers.remove(email);
	}
	


}
