package graphic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import personalbudgetingapp.Account;
import personalbudgetingapp.CategoryofIncome;
import personalbudgetingapp.DataStorage;
import personalbudgetingapp.Income;
import personalbudgetingapp.User;
import java.util.Currency;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class IncomeWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Income currentIncome;
	private User usuario;
	private ArrayList<Account> userAccounts;
	private ArrayList<Income> incomeListUser;
	private JPanel contentPane;
	private JFormattedTextField amountTextField;
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private Date today;
	private MainWindow mainWindow;
	private DataStorage data;
	

	public IncomeWindow(Income currentIncome, User usuario, MainWindow mainWindow, DataStorage data)
			throws HeadlessException {
		super();
		this.currentIncome = currentIncome;
		this.usuario = usuario;
		this.mainWindow = mainWindow;
		this.data = data;
		userAccounts = usuario.getUserAccounts();
		incomeListUser = usuario.getListIncome();
		today = new Date();
		incomeWindow();
	}

	private void incomeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setTitle("New Income");
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(0,0,0));
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(15, 79, 53, 17);
		amountLabel.setForeground(UIManager.getColor("Button.background"));
		amountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		numberFormat.setMinimumIntegerDigits(0);
		numberFormat.setMaximumFractionDigits(2);
		amountTextField = new JFormattedTextField(numberFormat);
		amountTextField.setBounds(15, 103, 118, 22);
		amountTextField.setColumns(10);
		
		JLabel accountLabel = new JLabel("Account");
		accountLabel.setBounds(15, 16, 53, 17);
		accountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		accountLabel.setForeground(UIManager.getColor("Button.background"));
		
		JLabel currencyLabel = new JLabel("Currency");
		currencyLabel.setBounds(151, 81, 45, 15);
		currencyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		currencyLabel.setForeground(UIManager.getColor("Button.background"));
		

		JFormattedTextField formattedCurrencyTextField = new JFormattedTextField();
		formattedCurrencyTextField.setBounds(151, 102, 60, 22);
		formattedCurrencyTextField.setBackground(new Color(105, 105, 105));
		formattedCurrencyTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		
		MutableComboBoxModel modelAccountsBox = new DefaultComboBoxModel<>(userAccounts.toArray(new Account[0]));
		JComboBox<Account> accountComboBox = new JComboBox<>(modelAccountsBox);
		accountComboBox.setBounds(15, 39, 196, 22);
		modelAccountsBox.setSelectedItem(-1);
		accountComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Account accountSelected = (Account) accountComboBox.getSelectedItem();
				Currency currencyAccount = accountSelected.getCurrencyAccount();
				formattedCurrencyTextField.setText(currencyAccount.getCurrencyCode());
			}
		});
		

		JLabel categoryLabel = new JLabel("Category ");
		categoryLabel.setBounds(15, 141, 55, 17);
		categoryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		categoryLabel.setForeground(UIManager.getColor("Button.background"));
		
		MutableComboBoxModel modelCategoryBox = new DefaultComboBoxModel<>(CategoryofIncome.values());
		JComboBox<CategoryofIncome> categoryComboBox = new JComboBox<>(modelCategoryBox);
		categoryComboBox.setBounds(15, 164, 196, 22);
		categoryComboBox.setSelectedIndex(-1);
	
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(15, 204, 38, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		
		SpinnerDateModel modelSpinner = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
		JSpinner spinnerDate = new JSpinner(modelSpinner);
		spinnerDate.setBounds(15, 227, 118, 20);
		spinnerDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerDate.setAlignmentY(CENTER_ALIGNMENT);
		
		JTextArea textAreaComments = new JTextArea();
		textAreaComments.setBounds(251, 38, 160, 177);
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
		
		if (currentIncome == null) {
			
			currentIncome = new Income();
		}
		else {
			accountComboBox.setSelectedItem(currentIncome.getAccountofTransaction());
			amountTextField.setText(String.valueOf(currentIncome.getAmountofTransaction()));
			formattedCurrencyTextField.setText(currentIncome.getCurrencyofTransaction().getCurrencyCode());
			categoryComboBox.setSelectedItem(currentIncome.getCategory());
			spinnerDate.setValue(currentIncome.getDateofTransaction().getTime());
			if (currentIncome.getComments()!= null) {
				textAreaComments.setText(currentIncome.getComments());
			}
			if (data.userHasIncome(usuario, currentIncome)) {
				data.deleteIncome(usuario, currentIncome);
				usuario.getListIncome().remove(currentIncome);
			}
			
		}
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setEnabled(true);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (accountComboBox.getSelectedIndex()==-1 
						|| amountTextField.getText().isEmpty() || categoryComboBox.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(IncomeWindow.this, "Please fill in all the required fields.");
		            return;
				}

				Account selectedAccount = (Account)modelAccountsBox.getSelectedItem();
				currentIncome.setAccountofTransaction(selectedAccount);
				
				String amountNotNumber = amountTextField.getText();
				double amountNumber = 0.0;
				try {
					amountNumber = Double.valueOf(amountNotNumber);
					currentIncome.setAmountofTransaction(amountNumber);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Invalid input. Please enter valid number, and use period (.) to separate decimals", "Error", JOptionPane.ERROR_MESSAGE );
					amountTextField.setValue(0.0);
					amountTextField.requestFocus();
				}
				
				currentIncome.setCurrencyofTransaction((Currency)((Account) modelAccountsBox.getSelectedItem()).getCurrencyAccount());
				currentIncome.setCategory(String.valueOf(modelCategoryBox.getSelectedItem()));
				Date selectedDate = modelSpinner.getDate();
				GregorianCalendar selectedCalendar = new GregorianCalendar();
				selectedCalendar.setTime(selectedDate);
				currentIncome.setDateofTransaction(selectedCalendar);
				try {
					currentIncome.setComments(textAreaComments.getText());
				} catch (NullPointerException e2) {
					currentIncome.setComments(null);
				}
				incomeListUser.add(currentIncome);
				usuario.getSpecificAccount(selectedAccount).updateAmountAccount(currentIncome);
				data.addUserIncome(usuario, currentIncome);
				mainWindow.updateIncomeList(incomeListUser);
				mainWindow.setVisible(true);
				dispose();
				
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnAdd.setBounds(339, 226, 72, 23);
		contentPane.add(btnAdd);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(251, 227, 72, 23);
		contentPane.add(btnNewButton);
	}
}
