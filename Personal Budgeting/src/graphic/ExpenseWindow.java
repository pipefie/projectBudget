package graphic;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;
import personalbudgetingapp.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;


public class ExpenseWindow extends JFrame {
	
	private MainWindow mainWindow;
	private Expenses currentExpense;
	private JPanel contentPane;
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private JFormattedTextField amountTextField;
	private Date today;
	private User currentUser;
	private ArrayList<Account> accountListUser; //null pointer piece of shit
	private ArrayList<Expenses> expenseListUser;
	private DataStorage data;
	

	public ExpenseWindow(MainWindow mainWindow, Expenses currentExpense, User currentUser, DataStorage data)
			throws HeadlessException {
		super();
		this.mainWindow = mainWindow;
		this.currentExpense = currentExpense;
		this.currentUser = currentUser;
		this.data = data;
		today = new Date();
		accountListUser = currentUser.getUserAccounts();
		expenseListUser = currentUser.getListExpenses();
		
		expenseWindow();
	}

	private void expenseWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		setResizable(false);
		setTitle("New Expense");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setBackground(new Color(0,0,0));
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(10, 74, 53, 17);
		amountLabel.setForeground(UIManager.getColor("Button.background"));
		amountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		numberFormat.setMinimumFractionDigits(0);
		numberFormat.setMaximumFractionDigits(2);
		amountTextField = new JFormattedTextField(numberFormat);
		amountTextField.setBounds(10, 98, 110, 22);
		amountTextField.setColumns(10);
		
		JLabel accountLabel = new JLabel("Account");
		accountLabel.setBounds(10, 11, 53, 17);
		accountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		accountLabel.setForeground(UIManager.getColor("Button.background"));
		
		JLabel currencyLabel = new JLabel("Currency");
		currencyLabel.setBounds(130, 76, 45, 15);
		currencyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		currencyLabel.setForeground(UIManager.getColor("Button.background"));
		
		JFormattedTextField formattedCurrencyTextField = new JFormattedTextField();
		formattedCurrencyTextField.setEditable(false);
		formattedCurrencyTextField.setBounds(130, 97, 60, 22);
		formattedCurrencyTextField.setBackground(new Color(105, 105, 105));
		formattedCurrencyTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	
		MutableComboBoxModel modelAccountBox = new DefaultComboBoxModel<>(accountListUser.toArray(new Account[0]));
		JComboBox<Account> accountComboBox = new JComboBox<>(modelAccountBox);
		accountComboBox.setBounds(10, 34, 196, 22);
		accountComboBox.setSelectedIndex(-1);
		accountComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Account selectedAccount = (Account)accountComboBox.getSelectedItem();
				Currency currencyAccount = selectedAccount.getCurrencyAccount();
				formattedCurrencyTextField.setText(currencyAccount.getCurrencyCode());
			}
		});
		
		JLabel categoryLabel = new JLabel("Category ");
		categoryLabel.setBounds(10, 136, 55, 17);
		categoryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		categoryLabel.setForeground(UIManager.getColor("Button.background"));
		
		MutableComboBoxModel modelCategoryExpense = new DefaultComboBoxModel<>(CategoryofExpense.values());
		JComboBox<CategoryofExpense> categoryComboBox = new JComboBox<>(modelCategoryExpense);
		categoryComboBox.setSelectedIndex(-1);
		
		MutableComboBoxModel<String> subcategoryModel = new DefaultComboBoxModel<>();
		JComboBox subcategoryComboBox = new JComboBox(subcategoryModel);
		subcategoryComboBox.setBounds(10, 217, 150, 22);
		contentPane.add(subcategoryComboBox);
		subcategoryComboBox.setSelectedIndex(-1);
		
		categoryComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				subcategoryComboBox.removeAllItems();
				
				if(categoryComboBox.getSelectedIndex()!=-1) {
					CategoryofExpense selectedCategory = (CategoryofExpense) categoryComboBox.getSelectedItem();
					for(String subcategory : selectedCategory.getSubcategories()) {
						subcategoryModel.addElement(subcategory);
					}	
				}	
			}
		});
		categoryComboBox.setBounds(10, 159, 196, 22);
		categoryComboBox.setSelectedIndex(-1);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(170, 196, 38, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		
		SpinnerDateModel modelSpinner = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
		JSpinner spinnerDate = new JSpinner(modelSpinner);
		spinnerDate.setBounds(170, 219, 100, 20);
		spinnerDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerDate.setAlignmentY(CENTER_ALIGNMENT);
		
		JTextArea textAreaComments = new JTextArea();
		textAreaComments.setBounds(251, 38, 160, 148);
		textAreaComments.setLineWrap(true);
		
		JLabel lblNewLabel_1 = new JLabel("Comments");
		lblNewLabel_1.setBounds(251, 16, 62, 17);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(UIManager.getColor("Button.background"));
		contentPane.setLayout(null);
		contentPane.add(amountLabel);
		contentPane.add(currencyLabel);
		contentPane.add(amountTextField);
		contentPane.add(formattedCurrencyTextField);
		contentPane.add(categoryLabel);
		contentPane.add(categoryComboBox);
		contentPane.add(lblNewLabel);
		contentPane.add(accountComboBox);
		contentPane.add(spinnerDate);
		contentPane.add(accountLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textAreaComments);
		
		if (currentExpense == null) {
			currentExpense = new Expenses();
			
		}
		
		else {
			accountComboBox.setSelectedItem(currentExpense.getAccountofTransaction());
			amountTextField.setText(String.valueOf(currentExpense.getAmountofTransaction()));
			formattedCurrencyTextField.setText(currentExpense.getCurrencyofTransaction().getCurrencyCode());
			categoryComboBox.setSelectedItem(CategoryofExpense.getCategoryFromSubcategory(String.valueOf(currentExpense.getCategory())));
			subcategoryComboBox.setSelectedItem(String.valueOf(currentExpense.getCategory()));
			spinnerDate.setValue(currentExpense.getDateofTransaction().getTime());
			if (currentExpense.getComments()!= null) {
				textAreaComments.setText(currentExpense.getComments());
			}
			if (data.userHasExpense(currentUser, currentExpense)) {
				data.deleteExpense(currentUser, currentExpense);
				currentUser.getListExpenses().remove(currentExpense);
			}
			
		}
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setEnabled(true);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(accountComboBox.getSelectedIndex()==-1 || amountTextField.getText().isEmpty() 
						|| categoryComboBox.getSelectedIndex()==-1 || subcategoryComboBox.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(ExpenseWindow.this, "Please fill in all the required fields.");
		            return;
				}
				

				
				Account selectedAccount = (Account)modelAccountBox.getSelectedItem();
				currentExpense.setAccountofTransaction(selectedAccount);
				
				String amountNotNumber = amountTextField.getText();
				double amountNumber = 0.0;
				try {
					amountNumber = Double.valueOf(amountNotNumber);
					currentExpense.setAmountofTransaction(amountNumber);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Invalid input. Please enter valid number, and use period (.) to separate decimals", "Error", JOptionPane.ERROR_MESSAGE );
					amountTextField.setValue(0.0);
					amountTextField.requestFocus();
				}
				currentExpense.setCurrencyofTransaction((Currency)((Account) modelAccountBox.getSelectedItem()).getCurrencyAccount());
				currentExpense.setCategory(String.valueOf(subcategoryComboBox.getSelectedItem()));
				Date selectedDate = modelSpinner.getDate();
				GregorianCalendar selectedCalendar = new GregorianCalendar();
				selectedCalendar.setTime(selectedDate);
				currentExpense.setDateofTransaction(selectedCalendar);
				try {
					currentExpense.setComments(textAreaComments.getText());
				} catch (NullPointerException e2) {
					currentExpense.setComments(null);
				}
				expenseListUser.add(currentExpense);
				currentUser.getSpecificAccount(selectedAccount).updateAmountAccount(currentExpense);
				data.addUserExpense(currentUser, currentExpense);
				mainWindow.updateExpenseList(expenseListUser);
				mainWindow.setVisible(true);
				dispose();
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnAdd.setBounds(344, 250, 60, 23);
		contentPane.add(btnAdd);
		

		
		JLabel lblSubcategory = new JLabel("Subcategory");
		lblSubcategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubcategory.setForeground(UIManager.getColor("Button.background"));
		lblSubcategory.setBounds(10, 196, 80, 14);
		contentPane.add(lblSubcategory);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(262, 250, 60, 23);
		contentPane.add(btnNewButton);
		
	}
}
